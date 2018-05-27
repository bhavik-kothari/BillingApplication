package my.assignment.billing.exception;

/**
 * Created by bkothari on 26/05/18.
 */
public class BillingException extends RuntimeException {

    public BillingException(String message) {
        super(message);
    }

    public BillingException(String message, Throwable throwable) {
        super(message, throwable);
    }


}
