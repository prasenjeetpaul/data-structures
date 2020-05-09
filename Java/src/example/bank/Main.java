package example.bank;

public class Main {

	public static void main(String args[]) {
		HDFCBank hdfc = new HDFCBank();
		Bank axis = new AxisBank();
		Bank andhra = new AndhraBankBanjaraHills();
		printBankInterestRate(hdfc);
		printBankInterestRate(axis);
		printBankInterestRate(andhra);
	}
	
	public static void printBankInterestRate(Bank bank) {
		System.out.format("%-35s => Interest Rate: %.2f\n", bank.getBankName(), bank.getInterestRate());
	}

}
