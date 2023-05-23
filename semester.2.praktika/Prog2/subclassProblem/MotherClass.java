package subclassProblem;

public class MotherClass {

	public MotherClass() {
		Test(this);
	}

	public static void main(String[] args) {
		new Subclass();

	}
	public void Test(MotherClass m) {
		if(m instanceof Subclass) {
			System.out.println("yes" + ((Subclass)m).get());
		}
	}

}
