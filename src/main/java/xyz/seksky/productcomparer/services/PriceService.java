package xyz.seksky.productcomparer.services;

import xyz.seksky.productcomparer.models.ProductPrice;
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

    public List<ProductPrice> getAll() {
        return priceRepo.findAll();
    }


}
