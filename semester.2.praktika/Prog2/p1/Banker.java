package p1;

public class Banker extends Person {
	public Banker(int income) {
		super(income);
	}

	@Override
	protected int calcTax() {
		return super.calcTax() + 1000 > income ? income : super.calcTax() + 1000;
	}
}
