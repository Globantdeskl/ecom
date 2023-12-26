
import com.aeo.framework.Application;
import com.aeo.framework.model.OrderStatus;
import com.aeo.framework.model.OrderType;
import io.restassured.response.ExtractableResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest(classes = Application.class)
public class SplitOrders extends BaseTest {

    @Test
    public void splitOrderTest() throws Exception {
        String orderId = usFaker.numerify("test########");
        //TODO: check quantity in order data before and after split
        publishOrder(orderId, OrderType.REGULAR_UNSPLIT_ORDER);

        ExtractableResponse responseSplit = splitOrder(orderId);
        Assert.assertEquals(responseSplit.statusCode(), 200, "Status code is not as expected");
        shovelMessageDLQ(orderId);
        ExtractableResponse response = getOrderHistory(orderId, 200);
        Assert.assertEquals(response.path("state[0]"), OrderStatus.RECEIVED_BY_PCF.name(), "Status is not as expected");
        Assert.assertEquals(response.path("state[1]"), OrderStatus.READY_FOR_PROCESSING.name(), "Status is not as expected");
        Assert.assertEquals(response.path("state[2]"), OrderStatus.PROCESSING.name(), "Status is not as expected");
    }

    @Test
    public void fraudDenyOrderTest() throws Exception {
        String orderId = usFaker.numerify("test########");
        publishOrder(orderId, OrderType.FRAUD_DENY_ORDER);
        //TODO: check quantity in order data before and after split
        ExtractableResponse responseSplit = splitOrder(orderId);
        Assert.assertEquals(responseSplit.statusCode(), 200, "Status code is not as expected");
        ExtractableResponse response = getOrderHistory(orderId, 200);
        Assert.assertEquals(response.path("state[0]"), OrderStatus.RECEIVED_CANCELLED.name(), "Status is not as expected");
        Assert.assertEquals(response.path("state[1]"), OrderStatus.READY_FOR_PROCESSING.name(), "Status is not as expected");
        Assert.assertEquals(response.path("state[2]"), OrderStatus.PROCESSING.name(), "Status is not as expected");
    }

    @Test(dataProvider = "OrderTypes")
    public void splitOrdersTest(OrderType orderType) throws Exception {
        String orderId = usFaker.numerify("test########");
        //TODO: check quantity in order data before and after split
        publishOrder(orderId, orderType);

        ExtractableResponse responseSplit = splitOrder(orderId);
        Assert.assertEquals(responseSplit.statusCode(), 200, "Status code is not as expected");
        shovelMessageDLQ(orderId);
        ExtractableResponse response = getOrderHistory(orderId, 200);
        Assert.assertEquals(response.path("state[0]"), OrderStatus.RECEIVED_BY_PCF.name(), "Status is not as expected");
        Assert.assertEquals(response.path("state[1]"), OrderStatus.READY_FOR_PROCESSING.name(), "Status is not as expected");
        Assert.assertEquals(response.path("state[2]"), OrderStatus.PROCESSING.name(), "Status is not as expected");
    }

    @DataProvider(name = "OrderTypes")
    public static Object[][] orderTypesSet() {
        return new Object[][] {{OrderType.SDD_ORDER},
                {OrderType.VGC_ONLY_ORDER},
                {OrderType.VGC_MIXED_ORDER}};
    }
}