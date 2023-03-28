package p2.model;

/**
 * Diese Aufzählung definiert den Typen eines Vehikels.
 */
public enum OperatingEnvironment {
	LAND("Land"), WATER("Wasser"), AIR("Luft");

	/**
	 * String-Name eines Types.
	 */
	private String name;

	/**
	 * Konstruktor eines Types.
	 * 
	 * @param name String-Name eines Types.
	 */
	private OperatingEnvironment(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
