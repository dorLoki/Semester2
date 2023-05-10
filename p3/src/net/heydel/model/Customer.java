package net.heydel.model;


import java.io.IOException;
import java.util.List;

public class Customer {
	private int id;
	private String name;
	private VehicleManagement management;

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setVehicleManagement(VehicleManagement management) {
		this.management = management;
	}

	public boolean searchAndBookVehicle(int minRequiredDistance, OperatingEnvironment environment) throws IOException {
		List<Vehicle> vehicles = management.findMatchingVehicles(minRequiredDistance, environment);
		for (Vehicle v : vehicles) {
			if (management.bookVehicle(v, this)) {
				return true;
			}
		}
		System.out.println("Es war keine geignete Buchung m�glich.");
		return false;
	}
}
