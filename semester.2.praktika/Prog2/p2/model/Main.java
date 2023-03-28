package p2.model;

public class Main {
	public static void main(String[] args) {
		VehicleManagement vMan = new VehicleManagement();
		Customer c1 = new Customer(1, "Bob");
		Customer c2 = new Customer(2, "Alice");
		Customer c3 = new Customer(3, "Max");
		Vehicle v1 = new Boat("Yacht", 1000);
		Vehicle v2 = new ECar("Tesla", 600);
		Vehicle v3 = new Helicopter("UH-1H", 700);
		Vehicle v4 = new Jetski("Jetski oder so", 150);
		Vehicle v5 = new Plane("F-16", 4000);
		Vehicle v6 = new SUV("Krasser SUV", 800);
		Vehicle v7 = new SUV("Noch Krasserer SUV", 1000);
		vMan.addVehicle(v1);
		vMan.addVehicle(v2);
		vMan.addVehicle(v3);
		vMan.addVehicle(v4);
		vMan.addVehicle(v5);
		vMan.addVehicle(v6);
		vMan.addVehicle(v7);
		c1.setVehicleManagement(vMan);
		c1.searchAndBookVehicle(800, OperatingEnvironment.LAND);
		vMan.showBookedVehicles();
		c1.searchAndBookVehicle(800, OperatingEnvironment.LAND);
		vMan.showBookedVehicles();
		c1.searchAndBookVehicle(800, OperatingEnvironment.LAND);
		vMan.showBookedVehicles();
		c2.setVehicleManagement(vMan);
		c2.searchAndBookVehicle(3000, OperatingEnvironment.AIR);
		vMan.showBookedVehicles();
		c2.searchAndBookVehicle(1, OperatingEnvironment.LAND);
		vMan.showBookedVehicles();
		c3.setVehicleManagement(vMan);
		c3.searchAndBookVehicle(1, OperatingEnvironment.AIR);
		vMan.showBookedVehicles();
		c3.searchAndBookVehicle(1, OperatingEnvironment.WATER);
		vMan.showBookedVehicles();
		c1.searchAndBookVehicle(1, OperatingEnvironment.WATER);
		vMan.showBookedVehicles();
		System.out.print("finished");
	}
}
