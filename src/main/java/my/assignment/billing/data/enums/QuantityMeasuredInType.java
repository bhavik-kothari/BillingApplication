package my.assignment.billing.data.enums;

/**
 * Created by bkothari on 26/05/18.
 */
public enum QuantityMeasuredInType {

    KGS("kgs"),
    LITRES("litres"),
    PIECES("pieces");

    private String value;

    QuantityMeasuredInType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
