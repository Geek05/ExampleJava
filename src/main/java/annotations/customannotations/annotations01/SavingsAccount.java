package annotations.customannotations.annotations01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SavingsAccount implements Account {	

	@Override
	@CollectMetrics
	public void getSavingsAmount() {
		List<Integer> amount = new ArrayList<>();
		try {
			for(int i=0;i<10;i++) {
				amount.add(Math.abs(new Random().nextInt()));
				Thread.sleep(20);
			}
			Integer sum = amount.stream().mapToInt(Integer::intValue).sum();
			System.out.println("total = "+sum);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printAccountNumber() {
		System.out.println("Account Number is 12345");
	}
}
