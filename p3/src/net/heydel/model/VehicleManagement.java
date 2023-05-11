package net.heydel.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
		return vehicles.stream().filter(v -> v.canOperateOn(environment))
				.filter(v -> v.getMaxDistance() >= minRequiredDistance).filter(v -> v.isAvailable()).toList();
	}

	public boolean bookVehicle(Vehicle vehicle, Customer customer) throws IOException {
		if (!vehicle.isAvailable()) {
			return false;
		}
		logBookingProcess(customer, vehicle);
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
		bookedVehicles.values().forEach(list -> list.forEach(vehicle -> System.out.println("- " + vehicle.getName())));
	}

	private void logBookingProcess(Customer customer, Vehicle vehicle) throws IOException {
		Path file = Paths.get("./logfile.txt");
		Charset charset = Charset.forName("US-ASCII");
		List<String> fileArray;
		fileArray = Files.readAllLines(file, charset);
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			for (Iterator<String> iterator = fileArray.iterator(); iterator.hasNext();) {
				String s = (String) iterator.next();
				writer.write(s);
				writer.newLine();
			}
			writer.write(customer.toString() + " - " + vehicle.toString());
		}
	}

	public int countAvailableVehicles() {
		return vehicles.stream().filter(v -> v.isAvailable()).mapToInt(value -> 1).sum();
	}
}
