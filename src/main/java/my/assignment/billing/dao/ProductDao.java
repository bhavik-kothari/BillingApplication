package my.assignment.billing.dao;

import my.assignment.billing.data.models.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by bkothari on 26/05/18.
 */
@Component
public interface ProductDao extends CrudRepository<ProductEntity, Long>{

    ProductEntity findByProductId(Long id);

}
