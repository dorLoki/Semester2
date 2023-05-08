package net.heydel.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleManagement {
	private Map<Integer, List<Vehicle>> bookedVehicles;
	private List<Vehicle> vehicles;

	public VehicleManagement() {
		bookedVehicles = new HashMap<>();
		vehicles = new ArrayList<>();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public List<Vehicle> findMatchingVehicles(int minRequiredDistance, OperatingEnvironment environment) {
		List<Vehicle> matched = new ArrayList<Vehicle>();
		for (Vehicle v : vehicles) {
			if (v.canOperateOn(environment) && v.getMaxDistance() >= minRequiredDistance && v.isAvailable()) {
				matched.add(v);
			}
		}
		return matched;
	}

	public boolean bookVehicle(Vehicle vehicle, Customer customer) {
		if(!vehicle.isAvailable()) {
			return false;
		}
		vehicle.book();
		int id = customer.getId();
		if (bookedVehicles.containsKey(id)) {
			bookedVehicles.get(id).add(vehicle);
		} else {
			ArrayList<Vehicle> list = new ArrayList<>();
			list.add(vehicle);
			bookedVehicles.put(id, list);
		}
		showBookedVehicles();
		return true;
	}

	public void showBookedVehicles() {
		System.out.println("Diese Vehicles sind gebucht: ");
		for (List<Vehicle> vehicleList : bookedVehicles.values()) {
			for (Vehicle vehicle : vehicleList) {
				System.out.println("- " + vehicle.getName());
			}
		}
	}
}
