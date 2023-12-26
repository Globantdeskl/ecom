import com.aeo.framework.controllers.CheckoutControllers;
import com.aeo.framework.model.TaxOrder;
import com.aeo.framework.model.response.TaxResponseBody;
import com.google.gson.Gson;
import data.TaxDataProviderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxCalculationTests extends BaseTest {

    @Autowired
    CheckoutControllers clientsBuilder;

    @Test(dataProvider = "tax-data-provider", dataProviderClass = TaxDataProviderClass.class, groups ={"tax"})
    public void taxCalculatorTest(TaxOrder taxOrder){
        TaxResponseBody responseBody = clientsBuilder.taxCalculatorClient().calculate(new Gson().toJson(taxOrder));
        Assert.assertNotNull(responseBody.getOrderId());
        Assert.assertNotNull(responseBody.getOrderTaxes().getTotalTax());
        Assert.assertNull(responseBody.getErrorMessage(), "Wrong error message");
    }
}
