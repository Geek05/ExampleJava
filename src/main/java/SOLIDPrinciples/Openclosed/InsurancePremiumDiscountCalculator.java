package SOLIDPrinciples.Openclosed;

public class InsurancePremiumDiscountCalculator {

    /**
     * InsurancePremiumDiscountCalculator is the core class
     */

    public int calculatePremiumDiscountPercent(ICustomerProfile customerProfile){
        //open closed principle is done here
        if(customerProfile.isLoyalCustomer()){
            return 30;
        }
        return 0;
    }
}
