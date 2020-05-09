package example.bank;


public class HDFCBank implements Bank {
	
	private final float INTEREST_RATE = 8.5f;
	private final String BANK_NAME = "HDFC Bank";

	@Override
	public String getBankName() {
		return this.BANK_NAME;
	}
	
	@Override
	public float getInterestRate() {
		return this.INTEREST_RATE;
	}
}
