package p2.model;


public class Customer {
	private int id;
	private String name;
	private VehicleManagement vMan;
	public Customer(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setVehicleManagement(VehicleManagement vMan) {
		this.vMan = vMan;
	}
	public boolean searchAndBookVehicle(int distance, OperatingEnvironment env) {
		return vMan.findMatchingVehicles(distance, env).isEmpty() ? false : true;
	}
}


