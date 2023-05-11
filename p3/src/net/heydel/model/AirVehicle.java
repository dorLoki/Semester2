package net.heydel.model;

public abstract class AirVehicle extends VehicleBase {
	public AirVehicle(String name, int distance) {
		super(name, distance, OperatingEnvironment.AIR);
	}
}
