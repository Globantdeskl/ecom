import com.aeo.framework.controllers.CheckoutControllers;
import com.aeo.framework.model.FraudRequest;
import com.aeo.framework.model.response.FraudResponse;
import com.google.gson.Gson;
import data.FraudDataProviderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FraudCheckTests extends BaseTest {

    @Autowired
    CheckoutControllers clientsBuilder;

    @Test(dataProvider = "fraud-data-provider", dataProviderClass = FraudDataProviderClass.class, groups = {"fraud"})
    public void fraudCheckTest(FraudRequest fraudRequest){
        FraudResponse responseBody = clientsBuilder.fraudCheckClient().check(new Gson().toJson(fraudRequest));
        Assert.assertNotNull(responseBody.getTokenId());
        Assert.assertTrue(responseBody.isSuccess());
    }
}
