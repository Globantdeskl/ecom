package ghostRetail;

import com.aeo.framework.model.ghostRetail.Item;
import com.aeo.framework.model.ghostRetail.OrderInfo;
import com.aeo.framework.model.ghostRetail.returnSummary.RefundSummary;
import com.aeo.framework.model.ghostRetail.returnSummary.Refunds;
import com.aeo.framework.model.ghostRetail.returnSummary.ReturnSummary;
import com.aeo.framework.model.ghostRetail.returnSummary.ReturnSummaryMessage;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class RefundMessageTest extends GRMessageBaseTest {

    @Test
    public void oneItemToRefund() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void twoItemsToRefund() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();
        Item item = new Item();
        item.setItemID(String.valueOf(getRandom10DigitsNumber()));
        message.getReturnSummary().getRefunds().getItems().add(item);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    // negative
    @Test
    public void emptyReturnSummary() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();
        message.setReturnSummary(null);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error error.partner.order.ReturnSummary.invalid (for now check manually in the app logs)
    }

    @Test
    public void emptyOrderInfo() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();
        message.getReturnSummary().setOrder(null);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.ReturnSummary.Order.invalid (for now check manually in the app logs)
    }

    @Test
    public void emptyPayments() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();
        message.getReturnSummary().setPaymentMethods(null);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.ReturnSummary.Payments.invalid (for now check manually in the app logs)
    }

    @Test
    public void emptyRefunds() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();
        message.getReturnSummary().setRefunds(null);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.ReturnSummary.Refunds.invalid (for now check manually in the app logs)
    }

    @Test
    public void emptyItems() throws Exception {
        // given
        ReturnSummaryMessage message = getBaseRefundMessage();
        message.getReturnSummary().getRefunds().setItems(null);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.ReturnSummary.Refunds.Items.invalid (for now check manually in the app logs)
    }

    private ReturnSummaryMessage getBaseRefundMessage() {
        ReturnSummaryMessage message = new ReturnSummaryMessage();
        message.setMessageType("ReturnSummary");
        ReturnSummary returnSummary = new ReturnSummary();
        message.setReturnSummary(returnSummary);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNumber(String.valueOf(getRandom10DigitsNumber()));
        orderInfo.setEntryType("GHOSTRETAIL");
        returnSummary.setOrder(orderInfo);

        com.aeo.framework.model.ghostRetail.PaymentMethod paymentMethod = new com.aeo.framework.model.ghostRetail.PaymentMethod();
        paymentMethod.setPaymentReference(UUID.randomUUID().toString());
        paymentMethod.setPaymentType("GHOSTRETAILPAY");
        returnSummary.setPaymentMethods(Collections.singletonList(paymentMethod));

        Refunds refunds = new Refunds();
        RefundSummary refundSummary = new RefundSummary();
        refundSummary.setMerchandiseCost(BigDecimal.TEN);
        refundSummary.setTaxAmount(BigDecimal.ONE);
        refundSummary.setTotalAmount(BigDecimal.ZERO);
        refunds.setRefundSummary(refundSummary);
        Item item = new Item();
        item.setItemID(String.valueOf(getRandom10DigitsNumber()));
        refunds.setItems(new ArrayList<>(Collections.singletonList(item)));
        returnSummary.setRefunds(refunds);

        return message;
    }
}
