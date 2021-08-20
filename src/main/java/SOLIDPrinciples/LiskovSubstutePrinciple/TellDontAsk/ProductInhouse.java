package SOLIDPrinciples.LiskovSubstutePrinciple.TellDontAsk;

public class ProductInhouse extends Product{

    @Override
    public double getDiscount(){
        return getInhouseDiscount();
    }

    private double getInhouseDiscount() {
        return discount * 1.5;
    }
}
