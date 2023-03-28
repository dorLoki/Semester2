package p2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Diese Klasse repräsentiert ein Management eines Vehikels.
 */
public class VehicleManagement {
	/**
	 * Liste der verfügbaren Vehikel.
	 */
	private List<Vehicle> vehicleList;
	/**
	 * Map der gebuchten Vehikel zu der ID eines Kunden.
	 */
	private Map<Integer, ArrayList<Vehicle>> bookedVehicle;

	/**
	 * Konstruktor für die Klasse.
	 */
	public VehicleManagement() {
		vehicleList = new ArrayList<Vehicle>();
		bookedVehicle = new HashMap<Integer, ArrayList<Vehicle>>();
	}

	/**
	 * Fügt ein Vehikel den Management hinzu.
	 * 
	 * @param v Das hinzufügende Vehikel.
	 */
	public void addVehicle(Vehicle v) {
		if (!vehicleList.contains(v)) {
			vehicleList.add(v);
		}
	}

	/**
	 * Sucht alle Vehikel, welche zu den Parametern passen und gibt diese Vehikel
	 * als Liste zurück.
	 * 
	 * @param distance Mindestreichweite der zu suchende Vehikel.
	 * @param env      Typ der zu suchende Vehikel.
	 * @return Liste aller passenden Vehikel.
	 */
	public List<Vehicle> findMatchingVehicles(int distance, OperatingEnvironment env) {
		return vehicleList.stream().filter(p -> p.getOperatingEnvironment() == env)
				.filter(p -> p.getMaxDistance() >= distance).toList();
	}

	/**
	 * Bucht ein Vehikel für einen Kunden.
	 * 
	 * @param v Das zu buchende Vehikel.
	 * @param c Der Kunde, welches das Vehikel buchen möchte.
	 * @return Ob das Vehikel gebucht werden konnte.
	 */
	public boolean bookVehicle(Vehicle v, Customer c) {
		if (v.isAvailable()) {
			ArrayList<Vehicle> temp;
			if (bookedVehicle.containsKey(c.getID())) {
				temp = bookedVehicle.get(c.getID());
			} else {
				temp = new ArrayList<Vehicle>();
			}
			v.book();
			temp.add(v);
			bookedVehicle.put(c.getID(), temp);
			return true;
		}
		return false;
	}

	/**
	 * Zeigt auf der Konsole alle gebuchten Vehikel für alle Kunden.
	 */
	public void showBookedVehicles() {
		for (Entry<Integer, ArrayList<Vehicle>> entry : bookedVehicle.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		System.out.println("--------------------");
	}
}
