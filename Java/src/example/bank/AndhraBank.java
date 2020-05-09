package example.bank;

public abstract class AndhraBank implements Bank {
	
	private final float INTEREST_RATE = 10f;
	protected final String BANK_NAME = "Andhra Bank";
	
	public float getInterestRate() {
		return this.INTEREST_RATE;
	}
	
}
