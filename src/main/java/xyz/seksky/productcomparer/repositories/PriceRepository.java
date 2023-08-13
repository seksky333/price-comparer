package xyz.seksky.productcomparer.repositories;

import xyz.seksky.productcomparer.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<ProductPrice, Long> {
}
