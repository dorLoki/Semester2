package p1;

public class Worker extends Person {
	public Worker(int income) {
		super(income);
	}

	@Override
	protected int calcTaxableIncome() {
		return super.calcTaxableIncome() < 2400 ? 0 : super.calcTaxableIncome() - 2400;
	}
}
