package xyz.seksky333.productcomparer.services;

import xyz.seksky333.productcomparer.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.seksky333.productcomparer.models.Product;
import xyz.seksky333.productcomparer.models.ProductEntry;
import xyz.seksky333.productcomparer.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository priceRepo) {
        this.productRepo = priceRepo;
    }

    public List<Product> getAll() {
        Map<String, Product> modelMap = new HashMap<>();
        List<ProductEntity> products = productRepo.findAll();

        for (ProductEntity product : products) {
            String model = product.getProductModel();
            if (modelMap.containsKey(model)) {
                ProductEntry newEntry = new ProductEntry(product.getSeller(), product.getProductPrice(), product.getReferenceUrl(), product.getViewDate());
                Product productModel = modelMap.get(model);
                List<ProductEntry> entries = productModel.productEntries();
                List<ProductEntry> newList = new ArrayList<>(entries);
                newList.add(newEntry);
                Product newProduct = new Product(productModel.productName(), productModel.productModel(), newList);
                modelMap.replace(model, newProduct);
            } else {
                ProductEntry seller = new ProductEntry(product.getSeller(), product.getProductPrice(), product.getReferenceUrl(), product.getViewDate());
                Product newProduct = new Product(product.getProductName(), product.getProductModel(),
                        List.of(seller));
                modelMap.put(model, newProduct);
            }
        }
        return new ArrayList<>(modelMap.values());
    }

    public void addPrice(ProductEntity price) {
        productRepo.save(price);
    }

    public Long getNextEntityId() {
        return Long.valueOf(productRepo.getNextId());
    }
}
