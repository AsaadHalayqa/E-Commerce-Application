package edu.bzu.app.eCommerceapi.repository;

import edu.bzu.app.eCommerceapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
