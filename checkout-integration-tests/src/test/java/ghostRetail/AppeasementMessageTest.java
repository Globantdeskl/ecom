package ghostRetail;

import com.aeo.framework.model.ghostRetail.Item;
import com.aeo.framework.model.ghostRetail.appeasementSummary.AppeasementOrderInfo;
import com.aeo.framework.model.ghostRetail.appeasementSummary.AppeasementSummaryMessage;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class AppeasementMessageTest extends GRMessageBaseTest {

    private static final List<String> APPEASEMENT_FIELDS = new ArrayList<String>(){{
        add("itemAmount");
        add("shippingAmount");
        add("taxAmount");
    }};

    @Test
    public void itemAppeasementOneItem() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setItemAmount(BigDecimal.TEN);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void itemAppeasementTwoItems() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setItemAmount(new BigDecimal(12.10));
        Item item = new Item();
        item.setItemID(String.valueOf(getRandom10DigitsNumber()));
        message.getItems().add(item);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void itemAppeasementNoItems() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setItemAmount(BigDecimal.TEN);
        message.setItems(new ArrayList<>());

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.orderLines.required (for now check manually in the app logs)
    }

    @Test
    public void shippingAppeasementOneItem() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setShippingAmount(BigDecimal.TEN);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void shippingAppeasementTwoItems() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setShippingAmount(new BigDecimal(6.43));
        Item item = new Item();
        item.setItemID(String.valueOf(getRandom10DigitsNumber()));
        message.getItems().add(item);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void shippingAppeasementNoItems() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setShippingAmount(new BigDecimal(0.7));
        message.setItems(new ArrayList<>());

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void taxAppeasementOneItem() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setTaxAmount(BigDecimal.TEN);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void taxAppeasementTwoItems() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setTaxAmount(new BigDecimal(6.43));
        Item item = new Item();
        item.setItemID(String.valueOf(getRandom10DigitsNumber()));
        message.getItems().add(item);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void taxAppeasementNoItems() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setTaxAmount(new BigDecimal(0.7));
        message.setItems(new ArrayList<>());

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then the message successfully processed and sent to GR (for now check manually in the app logs)
    }

    @Test
    public void appeasementIsNull() throws Exception {
        // given
        for (String field : APPEASEMENT_FIELDS) {
            AppeasementSummaryMessage message = getBaseAppeasementMessage();
            setField(message.getOrder(), field, null);

            // when
            String messageStr = mapper.writeValueAsString(message);
            publisherGRService.publish(messageStr);

            // then there is an error error.partner.order.Order.<fieldName>.invalid (for now check manually in the app logs)
        }
    }

    @Test
    public void negativeAppeasement() throws Exception {
        // given
        for (String field : APPEASEMENT_FIELDS) {
            AppeasementSummaryMessage message = getBaseAppeasementMessage();
            setField(message.getOrder(), field, new BigDecimal(-1));

            // when
            String messageStr = mapper.writeValueAsString(message);
            publisherGRService.publish(messageStr);

            // then there is an error error.partner.order.appeasement.amount.required (for now check manually in the app logs)
        }
    }

    @Test
    public void itemAndShippingAppeasements() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setItemAmount(BigDecimal.TEN);
        message.getOrder().setShippingAmount(BigDecimal.ONE);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error error.partner.order.multiple.appeasements.found (for now check manually in the app logs)
    }

    @Test
    public void itemAndTaxAppeasements() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.getOrder().setItemAmount(BigDecimal.TEN);
        message.getOrder().setTaxAmount(BigDecimal.ONE);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error error.partner.order.multiple.appeasements.found (for now check manually in the app logs)
    }

    @Test
    public void shippingAndTaxAppeasements() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.setItems(new ArrayList<>());
        message.getOrder().setShippingAmount(BigDecimal.TEN);
        message.getOrder().setTaxAmount(BigDecimal.ONE);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error error.partner.order.multiple.appeasements.found (for now check manually in the app logs)
    }

    @Test
    public void emptyOrderInfo() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.setOrder(null);

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.Order.invalid (for now check manually in the app logs)
    }

    @Test
    public void emptyPayments() throws Exception {
        // given
        AppeasementSummaryMessage message = getBaseAppeasementMessage();
        message.setPaymentMethods(new ArrayList<>());

        // when
        String messageStr = mapper.writeValueAsString(message);
        publisherGRService.publish(messageStr);

        // then there is an error.partner.order.paymentMethods.required (for now check manually in the app logs)
    }

    private AppeasementSummaryMessage getBaseAppeasementMessage() {
        AppeasementSummaryMessage message = new AppeasementSummaryMessage();
        message.setMessageType("AppeasementSummary");

        AppeasementOrderInfo orderInfo = new AppeasementOrderInfo();
        orderInfo.setOrderNumber(String.valueOf(getRandom10DigitsNumber()));
        orderInfo.setEntryType("GHOSTRETAIL");
        orderInfo.setItemAmount(BigDecimal.ZERO);
        orderInfo.setShippingAmount(BigDecimal.ZERO);
        orderInfo.setTaxAmount(BigDecimal.ZERO);
        message.setOrder(orderInfo);

        com.aeo.framework.model.ghostRetail.PaymentMethod paymentMethod = new com.aeo.framework.model.ghostRetail.PaymentMethod();
        paymentMethod.setPaymentReference(UUID.randomUUID().toString());
        paymentMethod.setPaymentType("GHOSTRETAILPAY");
        message.setPaymentMethods(Collections.singletonList(paymentMethod));

        Item item = new Item();
        item.setItemID(String.valueOf(getRandom10DigitsNumber()));
        message.setItems(new ArrayList<>(Collections.singletonList(item)));

        return message;
    }
}
