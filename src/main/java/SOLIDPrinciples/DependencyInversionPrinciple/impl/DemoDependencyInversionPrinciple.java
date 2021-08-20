package SOLIDPrinciples.DependencyInversionPrinciple.impl;

public class DemoDependencyInversionPrinciple {

    public static void main(String[] args) {
        ProductRepository productRepository = ProductFactory.create();
        ProductCatalog productCatalog = new ProductCatalog(productRepository);
        productCatalog.listAllProducts();
    }
}
