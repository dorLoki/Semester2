package net.heydel.model;


public abstract class WaterVehicle extends VehicleBase {

	public WaterVehicle(String name, int distance) {
		super(name, distance, OperatingEnvironment.WATER);
	}
}
