package SOLIDPrinciples.LiskovSubstutePrinciple.TellDontAsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PricingUtils {

    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new ProductInhouse();

        List<Product> productList = Arrays.asList(new Product[] {p1, p2, p3});

        productList.forEach(
                product -> {
                    System.out.println(product.getDiscount());
                }
        );
    }
}
