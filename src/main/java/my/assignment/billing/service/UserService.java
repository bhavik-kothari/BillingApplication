package my.assignment.billing.service;

import my.assignment.billing.data.dto.UserDto;

/**
 * Created by bkothari on 26/05/18.
 */
public interface UserService {

    UserDto getUserByUsername(final String username);

}
