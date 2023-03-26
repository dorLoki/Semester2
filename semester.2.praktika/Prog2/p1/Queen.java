package p1;

public class Queen extends Person {
	public Queen(int income) {
		super(income);
	}

	@Override
	protected int calcTaxableIncome() {
		return 0;
	}
}
