package p1;

public class FinanceOffice {

	public static void main(String[] args) {
		Person joeUnemployed = new Person(6400);
		Worker suziHardworking = new Worker(36000);
		Banker fredMoneymaker = new Banker(4000000);
		Queen elisabeth = new Queen(1000000);
		Banker billyBadLuck = new Banker(500);

		Person[] persons = { joeUnemployed, suziHardworking, fredMoneymaker, elisabeth, billyBadLuck };

		FinanceOffice ukOffice = new FinanceOffice();
		System.out.println("Steuereinnahmen des Landes: " + ukOffice.calculateSumOfTaxes(persons) + " Pfund");
	}

	/**
	 * Calculates the sum of the taxes of given persons.
	 * 
	 * @param personArray some persons
	 * @return the sum of all the taxes of the persons
	 */
	public int calculateSumOfTaxes(Person[] personArray) {
		int taxSum = 0;
		for (Person p : personArray) {
			taxSum += p.calcTax();
		}
		return taxSum;
	}
}