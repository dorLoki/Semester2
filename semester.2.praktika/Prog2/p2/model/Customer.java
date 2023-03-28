package p2.model;

import java.util.List;

/**
 * Diese Klasse repräsentiert einen Kunden.
 */
public class Customer {
	/**
	 * ID eines Kunden.
	 */
	private int id;
	/**
	 * Name eines Kunden.
	 */
	private String name;
	/**
	 * Vehikelmanagement eines Kunden.
	 */
	private VehicleManagement vMan;

	/**
	 * Konstruktor für einen Kunden.
	 * 
	 * @param id   Die ID des Kunden.
	 * @param name Der Name des Kunden.
	 */
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Accessor für die ID des Kunden.
	 * 
	 * @return ID des Kunden.
	 */
	public int getID() {
		return id;
	}

	/**
	 * Setter für den Namen des Kunden.
	 * 
	 * @return Name des Kunden.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter für den Vehikelmanagement des Kunden.
	 * 
	 * @param vMan Vehikelmanagement des Kunden.
	 */
	public void setVehicleManagement(VehicleManagement vMan) {
		this.vMan = vMan;
	}

	/**
	 * Sucht und bucht ein Vehikel, welche mindestens eine Reichweite von distance
	 * hat und vom Typ env ist.
	 * 
	 * @param distance Mindestreichweite des zu suchende Vehikel.
	 * @param env      Typ des Vehikel
	 * @return true, falls ein Vehikel gebucht wurde. false, falls kein Vehikel
	 *         gebucht wurde.
	 */
	public boolean searchAndBookVehicle(int distance, OperatingEnvironment env) {
		if (vMan == null) {
			System.out.println(name + " hat kein VehicleManagement!");
			return false;
		}
		List<Vehicle> temp = vMan.findMatchingVehicles(distance, env);
		for (Vehicle v : temp) {
			if (vMan.bookVehicle(v, this)) {
				return true;
			}
		}
		return false;
	}
}
