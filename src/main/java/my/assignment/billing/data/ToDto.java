package my.assignment.billing.data;

import java.io.Serializable;

/**
 * Created by bkothari on 26/05/18.
 */
public interface ToDto<T> extends Serializable {

    T toDto();

}
