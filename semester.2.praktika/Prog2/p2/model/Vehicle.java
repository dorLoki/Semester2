package p2.model;

/**
 * Dieses Interface repräsentiert ein Vehikel, welches gebucht werden kann und
 * von einen spezifisches Typen ist. Des Weiteren hat es einen Namen und eine
 * maximale Reichweite.
 */
public interface Vehicle {
	/**
	 * Prüft ob das Vehikel verfügbar ist.
	 * 
	 * @return Ob das Fahrzeug verfügbar ist.
	 */
	public boolean isAvailable();

	/**
	 * Accessor für die Reichweite des Vehikels.
	 * 
	 * @return Reichweite des Vehikel.
	 */
	public int getMaxDistance();

	/**
	 * Accessor des Typen des Vehikel.
	 * 
	 * @return Typen des Vehikel.
	 */
	public OperatingEnvironment getOperatingEnvironment();

	/**
	 * Accessor des Namens des Vehikel.
	 * 
	 * @return Name des Vehikel.
	 */
	public String getName();

	/**
	 * Bucht ein Vehikel.
	 */
	public void book();

	/**
	 * Checkt ob ein Vehikel von einen bestimmten Typen ist.
	 * 
	 * @param env Der zu checkende Typ.
	 * @return Ob das Vehikel des Typen env ist.
	 */
	public boolean canOperateOn(OperatingEnvironment env);
}
