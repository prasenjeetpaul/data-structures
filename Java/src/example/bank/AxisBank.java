package example.bank;

public class AxisBank implements Bank {
	private final float INTEREST_RATE = 10.5f;
	private final String BANK_NAME = "Axis Bank";

	@Override
	public String getBankName() {
		return this.BANK_NAME;
	}
	
	@Override
	public float getInterestRate() {
		return this.INTEREST_RATE;
	}
	
	//Its own methods...
}
