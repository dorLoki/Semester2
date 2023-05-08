package net.heydel.model;

public abstract class LandVehicle extends VehicleBase {

	public LandVehicle(String name, int distance) {
		super(name, distance, OperatingEnvironment.LAND);
	}
}
