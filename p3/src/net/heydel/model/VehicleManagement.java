package net.heydel.model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.heydel.VehicleBookingMainApp;

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

	public boolean bookVehicle(Vehicle vehicle, Customer customer) throws IOException {
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
		logBookingProcess(customer, vehicle);
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
	private void logBookingProcess(Customer customer, Vehicle vehicle) throws IOException {
		Path file = Paths.get("./logfile.txt");
		Charset charset = Charset.forName("US-ASCII");
		List<String> fileArray;
		fileArray = Files.readAllLines(file);
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			for (Iterator<String> iterator = fileArray.iterator(); iterator.hasNext();) {
				String s = (String) iterator.next();
				writer.write(s);
				writer.newLine();
			}
			writer.write(customer.toString()+" - " +vehicle.toString());
		}
	}
}
