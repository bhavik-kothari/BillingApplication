package my.assignment.billing.service.impl;

import my.assignment.billing.dao.UserDao;
import my.assignment.billing.data.dto.UserDto;
import my.assignment.billing.data.models.UserEntity;
import my.assignment.billing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bkothari on 26/05/18.
 */
@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Override
    public UserDto getUserByUsername(String username) {
        LOGGER.info("getUserByUsername method started");

        UserEntity userEntity = userDao.findByUsername(username);

        if(userEntity != null) {
            return userEntity.toDto();
        }

        return null;
    }
}
