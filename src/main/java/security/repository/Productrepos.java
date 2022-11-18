package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import security.entity.Product;
@Repository

public interface Productrepos extends JpaRepository<Product,Integer>{

}
