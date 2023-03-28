package p2.model;

/**
 * Diese Abstrakte Klasse repräsentiert die Basis aller Vehikel. Dabei wird das
 * Interface Vehicle implementiert.
 */
public abstract class VehicleBase implements Vehicle {
	/**
	 * Reichweite eines Vehikels.
	 */
	private int maxDistance;
	/**
	 * Verfügbarkeit eines Vehikels.
	 */
	private boolean available = true;
	/**
	 * Name eines Vehikels.
	 */
	private String name;
	/**
	 * Typ eines Vehikels.
	 */
	private OperatingEnvironment operatingEnvironment;

	/**
	 * Konstruktor der Basis eines Vehikels.
	 * 
	 * @param name        Name des Vehikels.
	 * @param maxDistance Reichweite des Vehikels.
	 * @param env         Typ eines Vehikels.
	 */
	public VehicleBase(String name, int maxDistance, OperatingEnvironment env) {
		this.name = name;
		this.maxDistance = maxDistance;
		this.operatingEnvironment = env;
	}

	@Override
	public OperatingEnvironment getOperatingEnvironment() {
		return operatingEnvironment;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public int getMaxDistance() {
		return this.maxDistance;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean canOperateOn(OperatingEnvironment env) {
		return env == operatingEnvironment ? true : false;
	}

	@Override
	public void book() {
		this.available = false;
	}

	@Override
	public String toString() {
		return "Name: " + name + "|Maximale Distanz: " + maxDistance + "|Typ: " + operatingEnvironment;
	}

	/**
	 * Setter für den Typen eines Vehikels.
	 * 
	 * @param env Zu setzende Typ.
	 */
	public void setOperatingEnvironment(OperatingEnvironment env) {
		this.operatingEnvironment = env;
	}

	/**
	 * Setter für die Verfügbarkeit eines Vehikels.
	 * 
	 * @param b Verfügbarkeit eines Vehikels.
	 */
	public void setAvailable(boolean b) {
		this.available = b;
	}

	/**
	 * Setter für die maximale Reichweite eines Vehikels.
	 * 
	 * @param d Reichweite des Vehikels.
	 */
	public void setMaxDistance(int d) {
		this.maxDistance = d;
	}

	/**
	 * Setter für den Namen eines Vehikels.
	 * 
	 * @param name Name des Vehikels
	 */
	public void setName(String name) {
		this.name = name;
	}
}
