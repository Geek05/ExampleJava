package SOLIDPrinciples.DependencyInversionPrinciple.impl;

public class ProductFactory {

    public static ProductRepository create(){
        return new SQLRepository();
    }
}
