package ghostRetail;

import com.aeo.framework.Application;
import com.aeo.framework.GRPublishService;
import com.aeo.framework.model.ghostRetail.finalStatus.FinalOrderStatusMessage;
import com.aeo.framework.model.ghostRetail.finalStatus.OrderLine;
import com.aeo.framework.model.ghostRetail.finalStatus.OrderLineExtn;
import com.aeo.framework.model.ghostRetail.finalStatus.PaymentMethod;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.lang.reflect.Field;
import java.util.*;

import static io.restassured.RestAssured.given;

@SpringBootTest(classes = Application.class)
public class GRMessageBaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected GRPublishService publisherGRService;

    @Value("${partner-communications-utility.authorizationHeader}")
    private String authorizationHeader;

    @Value("${partner-communications-utility.url}")
    private String partnerCommunicationsUtilityUrl;

    protected ObjectMapper mapper = new ObjectMapper();
    protected final static String SHIPPED_STATUS = "Shipped And Invoiced";
    protected final static String CANCELLED_STATUS = "Cancelled";
    protected final static Map<String, Object> FINAL_ORDER_STATUS_MSG_REQUIRED_FIELDS = new HashMap<String, Object>(){{
        put("messageType", "invalid");
        put("transactionType", "invalid");
        put("orderDate", "invalid");
        put("status", "invalid");
        put("gatewayIndicator", "invalid");
        put("orderLines", new ArrayList<>());
        put("paymentMethods", new ArrayList<>());
    }};

    protected FinalOrderStatusMessage generateFinalOrderStatusMessage(String transactionType) {
        String status = transactionType.equals("capture") ? SHIPPED_STATUS : CANCELLED_STATUS;
        FinalOrderStatusMessage message = new FinalOrderStatusMessage();
        message.setMessageType("FinalOrderStatus");
        message.setOrderNo(String.valueOf(getRandom10DigitsNumber()));
        message.setOrderDate("2021-01-28T05:56:25-05:00");
        message.setGatewayIndicator("GHOSTRETAIL");
        message.setStatus(status);
        message.setTransactionType(transactionType);
        message.setTransactionID(UUID.randomUUID().toString());
        message.setOrderLines(generateOrderLines(status, 1));
        message.setPaymentMethods(generatePaymentMethods());
        return message;
    }

    protected List<OrderLine> generateOrderLines(String status, int count) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            OrderLine orderLine = new OrderLine();
            orderLine.setItemID(String.valueOf(getRandom10DigitsNumber()));
            orderLine.setStatus(status);
            OrderLineExtn extn = new OrderLineExtn();
            extn.setExtnCommerceItemID("ci" + getRandom10DigitsNumber());
            orderLine.setExtn(extn);
            orderLines.add(orderLine);
        }
        return orderLines;
    }

    private List<PaymentMethod> generatePaymentMethods() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentReference2(UUID.randomUUID().toString());
        paymentMethod.setPaymentReference3("pg" + getRandom10DigitsNumber());
        paymentMethod.setPaymentType("GHOSTRETAILPAY");
        paymentMethods.add(paymentMethod);
        return paymentMethods;
    }

    protected long getRandom10DigitsNumber() {
        return (long)(Math.random() * 9999999999L);
    }

    protected void setField(Object message, String fieldName, Object value) throws IllegalAccessException {
        List<Field> fields = new ArrayList<>(Arrays.asList(message.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(message.getClass().getSuperclass().getDeclaredFields()));
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                field.set(message, value);
            }
        }
    }

    // for now this method is not used but it could be helpful when there is no ability to publish the message directly to pubsub (for example an issue with credentials)
    protected void publishMessage(String message) {
        given().
                contentType(ContentType.JSON).
                relaxedHTTPSValidation().
                header("Authorization", authorizationHeader).
                body(message).
                when().
                post(partnerCommunicationsUtilityUrl).
                then().
                statusCode(HttpStatus.OK.value());
    }
}
