package ghostRetail;

import com.aeo.framework.model.ghostRetail.finalStatus.FinalOrderStatusMessage;
import org.testng.annotations.Test;

import java.util.Map;

public class CaptureMessageTest extends GRMessageBaseTest {

    @Test
    public void oneItemWithShippedStatus() throws Exception {
        // given
        FinalOrderStatusMessage message = getBaseCaptureMessage();

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void oneItemWithCancelledStatus() throws Exception {
        // given
        FinalOrderStatusMessage message = getBaseCaptureMessage();
        message.setOrderLines(generateOrderLines(CANCELLED_STATUS, 1));

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error error.partner.order.orderLines.status.mismatch (for now check manually in the app logs)
    }

    @Test
    public void twoItemsWithShippedStatus() throws Exception {
        // given
        FinalOrderStatusMessage message = getBaseCaptureMessage();
        message.setOrderLines(generateOrderLines(SHIPPED_STATUS, 2));

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void twoItemsWithCancelledStatus() throws Exception {
        // given
        FinalOrderStatusMessage message = getBaseCaptureMessage();
        message.setOrderLines(generateOrderLines(CANCELLED_STATUS, 2));

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error error.partner.order.orderLines.status.mismatch (for now check manually in the app logs)
    }

    @Test
    public void twoItemsOneShippedAnotherOneCancelled() throws Exception {
        // given
        FinalOrderStatusMessage message = getBaseCaptureMessage();
        message.setOrderLines(generateOrderLines(SHIPPED_STATUS, 1));
        message.getOrderLines().addAll(generateOrderLines(CANCELLED_STATUS, 1));

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void fourItemsTwoShippedOtherTwoCancelled() throws Exception {
        // given
        FinalOrderStatusMessage message = getBaseCaptureMessage();
        message.setOrderLines(generateOrderLines(SHIPPED_STATUS, 1));
        message.getOrderLines().addAll(generateOrderLines(CANCELLED_STATUS, 1));
        message.getOrderLines().addAll(generateOrderLines(SHIPPED_STATUS, 1));
        message.getOrderLines().addAll(generateOrderLines(CANCELLED_STATUS, 1));

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void checkRequiredFields() throws Exception {
        // given
        for (String requiredField : FINAL_ORDER_STATUS_MSG_REQUIRED_FIELDS.keySet()) {
            FinalOrderStatusMessage message = getBaseCaptureMessage();
            setField(message, requiredField, null);

            // when
            String messageStr = mapper.writeValueAsString(message);
            publisherGRService.publish(messageStr);

            // then there is an error error.partner.order.<fieldName>.invalid (for now check manually in the app logs)
        }
    }

    @Test
    public void checkInvalidFields() throws Exception {
        // given
        for (Map.Entry<String, Object> requiredField : FINAL_ORDER_STATUS_MSG_REQUIRED_FIELDS.entrySet()) {
            FinalOrderStatusMessage message = getBaseCaptureMessage();
            setField(message, requiredField.getKey(), requiredField.getValue());

            // when
            String messageStr = mapper.writeValueAsString(message);
            publisherGRService.publish(messageStr);

            // then there is an error error.partner.order.<fieldName>.invalid (for now check manually in the app logs)
        }
    }

    private FinalOrderStatusMessage getBaseCaptureMessage() {
        return generateFinalOrderStatusMessage("capture");
    }
}
