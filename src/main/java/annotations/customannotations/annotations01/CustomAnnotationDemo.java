package annotations.customannotations.annotations01;

/**
 * 
 * @author Bharath.MC
 * Extracts/logs execution time of an invoked method
 * 
 * Reference of an RunTime annotation processing.
 *        http://javadevtips.blogspot.com/2011/10/full-working-runtime-annotation-example_30.html 
 *
 */
public class CustomAnnotationDemo {

	public static void main(String[] args) {
		Account savingsAccount= new SavingsAccount();
		Account account = (Account) CollectMetricsInvocationHandler.getNewProxy( savingsAccount , Account.class);
		account.getSavingsAmount();
		account.printAccountNumber();
	}
}
