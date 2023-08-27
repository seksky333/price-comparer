package xyz.seksky.productcomparer.repositories;

import org.springframework.data.jpa.repository.Query;
import xyz.seksky.productcomparer.Entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<ProductPriceEntity, Long> {
    String GET_NEXT_ID = "SELECT max(id) + 1 AS \"next_id\" FROM price LIMIT 1;";

    @Query(
            value = GET_NEXT_ID,
            nativeQuery = true
    )
    int getNextId();
}
