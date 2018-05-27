package my.assignment.billing.dao;

import my.assignment.billing.data.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by bkothari on 26/05/18.
 */
@Component
public interface UserDao extends CrudRepository<UserEntity, Long> {

        UserEntity findByUsername(String username);

}
