package xyz.seksky.productcomparer.services;

import xyz.seksky.productcomparer.Entity.ProductPriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.seksky.productcomparer.repositories.PriceRepository;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepo;

    @Autowired
    public PriceService(PriceRepository priceRepo) {
        this.priceRepo = priceRepo;
    }

    public List<ProductPriceEntity> getAll() {
        return priceRepo.findAll();
    }

    public void addPrice(ProductPriceEntity price) {
        priceRepo.save(price);
    }

    public Long getNextEntityId() {
        return Long.valueOf(priceRepo.getNextId());
    }
}
