package xyz.seksky333.productcomparer.models;

import java.util.List;

public record Product(String productName,
                      String productModel,
                      List<ProductEntry> productEntries
) {
}