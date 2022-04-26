package edu.bzu.app.eCommerceapi.repository;

import edu.bzu.app.eCommerceapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
