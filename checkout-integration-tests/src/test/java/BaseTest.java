import com.aeo.framework.Application;
import com.aeo.framework.Environment;
import com.aeo.framework.PublisherService;
import com.aeo.framework.model.OrderType;
import com.aeo.framework.model.RabbitQueues;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import org.awaitility.Awaitility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;

@SpringBootTest(classes = Application.class)
@Configuration
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    Environment environment;

    @Autowired
    private PublisherService publisherService;

    @Value("${testEmail}")
    String testEmail;

    @Value("${apisg.authorizationHeader}")
    String apisgAuthorizationHeader;

    @Value("${spring.cloud.gcp.credentials.encoded-key}")
    private String encodedKey;

    @Value("${checkout-framework.split-order}")
    protected String splitOrderEndpoint;

    @Value("${checkout-framework.get-order}")
    protected String getOrderEndpoint;

    @Value("${checkout-framework.submit-order}")
    protected String submitOrderEndpoint;

    @Value("${checkout-framework.fulfillment-utility-get-message-from-queue-url}")
    private String fulfillmentUtilityGetMessageFromQueueUrl;

    @Value("${checkout-framework.fulfillment-utility-shovel-message-url}")
    private String fulfillmentUtilityShovelMessageUrl;

    public Faker usFaker = new Faker(Locale.US);

    public void publishOrder(String orderId, OrderType orderType) throws Exception {
        publisherService.publishOrder(encodedKey, orderId, testEmail, orderType);
    }


    protected ExtractableResponse splitOrder(String pathParam) {
        RestAssured.baseURI = environment.submitOrderRestController;

        return
                given().
                        contentType(ContentType.JSON).
                        pathParam("orderId", pathParam).
                        relaxedHTTPSValidation().
                        when().
                        get(splitOrderEndpoint).
                        then().
                        extract();
    }

    protected ExtractableResponse submitOrder(String pathParam) {
        RestAssured.baseURI = environment.submitOrderRestController;

        return
                given().
                        contentType(ContentType.JSON).
                        pathParam("orderId", pathParam).
                        relaxedHTTPSValidation().
                        when().
                        get(submitOrderEndpoint).
                        then().
                        extract();
    }

    public ExtractableResponse getMessageFromRMQ(String queueName, String value) {
        return
                given().
                        contentType(ContentType.JSON).
                        relaxedHTTPSValidation().
                        pathParam("queue", queueName).
                        pathParam("value", value).
                        when().
                        get(environment.fulfillmentUtility + fulfillmentUtilityGetMessageFromQueueUrl).
                        then().
                        statusCode(200).
                        extract();
    }

    public ExtractableResponse getMessageFromRMQNoCode(String queueName, String value) {
        return
                given().
                        contentType(ContentType.JSON).
                        relaxedHTTPSValidation().
                        pathParam("queue", queueName).
                        pathParam("value", value).
                        when().
                        get(environment.fulfillmentUtility + fulfillmentUtilityGetMessageFromQueueUrl).
                        then().
                        extract();
    }

    public JSONArray getMessageIdByOrderIdFromRMQ(String orderId) {
        JSONArray array = new JSONArray();
        Awaitility.with().pollInterval(3, SECONDS).await().atMost(10,SECONDS).until(()-> getMessageFromRMQ(RabbitQueues.ORDERS_FINAL.toString(), orderId).path("message") != null);
        array.put(getMessageFromRMQ(RabbitQueues.ORDERS_FINAL.toString(), orderId).path("message.messageProperties.messageId").toString());
        return array;
    }

    protected ExtractableResponse getOrderHistory(String pathParam) {
        RestAssured.baseURI = environment.fulfillmentUtility;

        return
                given().
                        contentType(ContentType.JSON).
                        pathParam("orderId", pathParam).
                        relaxedHTTPSValidation().
                        when().
                        get(getOrderEndpoint + "/history").
                        then().
                        extract();
    }

    protected ExtractableResponse getOrderHistory(String orderId, int expectedStatus) {
        Awaitility.with().pollInterval(3, SECONDS).await().atMost(10,SECONDS).until(()-> getOrderHistory(orderId).statusCode() == expectedStatus);
        return getOrderHistory(orderId);
    }

    protected ExtractableResponse getOrderData(String pathParam) {
        RestAssured.baseURI = environment.fulfillmentUtility;

        return
                given().
                        contentType(ContentType.JSON).
                        pathParam("orderId", pathParam).
                        relaxedHTTPSValidation().
                        when().
                        get(getOrderEndpoint).
                        then().
                        extract();
    }

    protected ExtractableResponse getOrderData(String orderId, int expectedStatus) {
        Awaitility.with().pollInterval(3, SECONDS).await().atMost(10,SECONDS).until(()-> getOrderData(orderId).statusCode() == expectedStatus);
        return getOrderData(orderId);
    }

    //Skip remorse period
    public void shovelMessageDLQ(String orderId) throws JSONException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("messageIds", getMessageIdByOrderIdFromRMQ(orderId));

        given().
                contentType(ContentType.JSON).
                relaxedHTTPSValidation().
                pathParam("fromQueue", RabbitQueues.ORDERS_FINAL.toString()).
                pathParam("toQueue", RabbitQueues.ORDERS_FINAL_FINAL.toString()).
                body(requestParams.toString()).
                when().
                post(environment.fulfillmentUtility + fulfillmentUtilityShovelMessageUrl).
                then().
                statusCode(200).
                extract();
    }
}
