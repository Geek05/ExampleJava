package SOLIDPrinciples.DependencyInversionPrinciple.impl;

public class ProductCatalog {
    private ProductRepository productRepository;

    public ProductCatalog(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void listAllProducts(){
        System.out.println(this.productRepository.getAllProductNames());
    }
}
