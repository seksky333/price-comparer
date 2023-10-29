package xyz.seksky333.productcomparer.repositories;

import org.springframework.data.jpa.repository.Query;
import xyz.seksky333.productcomparer.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    String GET_NEXT_ID = "SELECT max(id) + 1 AS \"next_id\" FROM price LIMIT 1;";

    @Query(
            value = GET_NEXT_ID,
            nativeQuery = true
    )
    int getNextId();
}
