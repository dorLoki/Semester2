package p1;

public class Person {
	protected int income;

	public Person(int income) {
		this.income = income;
	}

	protected int calcTaxableIncome() {
		return income;
	}

	protected int calcTax() {
		return (int) Math.round(calcTaxableIncome() * 0.25);
	}
}
