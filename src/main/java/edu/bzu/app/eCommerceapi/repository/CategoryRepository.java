package edu.bzu.app.eCommerceapi.repository;

import edu.bzu.app.eCommerceapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
