package data;

import com.aeo.framework.model.TaxOrder;
import com.aeo.framework.model.TaxableItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Address;
import com.github.javafaker.Currency;
import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
public class TaxDataProviderClass {

    @DataProvider(name = "tax-data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { taxOrder( 7.00, taxableItems(140.00, 1, "88888")) },
                { taxOrder(7.00, taxableItems(151.00, 1, "88888")) }
        };
    }

    private TaxOrder taxOrder(Double shippingCost, TaxableItems taxableItem){

        Faker usFaker = new Faker(Locale.US);
        TaxOrder taxOrder = new TaxOrder();
        List<TaxableItems> taxableItems = new ArrayList<>();
        Address address = usFaker.address();
        String state = address.stateAbbr();
        taxOrder.setOrderId(usFaker.numerify("test########"));
        taxOrder.setCurrencyCode("USD");
        taxOrder.setAddressLine1(address.streetName());
        taxOrder.setAddressLine2(address.buildingNumber());
        taxOrder.setCity(address.city());
        taxOrder.setState(state);
        taxOrder.setCountry(address.countryCode());
        taxOrder.setPostalCode(address.zipCodeByState(state));
        taxOrder.setShippingGroupId("shippingGroupId");
        taxOrder.setShippingCost(shippingCost);

        taxableItems.add(taxableItem);

        taxOrder.setTaxableItems(taxableItems);

        return taxOrder;
    }

    private TaxableItems taxableItems(Double amount, int quantity, String taxCode){
        TaxableItems taxableItem = new TaxableItems();

        taxableItem.setAmount(amount);
        taxableItem.setCommerceItemId("1");
        taxableItem.setQuantity(quantity);
        taxableItem.setSkuId("0021765045");
        taxableItem.setTaxCode(taxCode);

        return taxableItem;
    }
}
