package p2.model;

public abstract class WaterVehicle extends VehicleBase {
	public WaterVehicle(String name, int maxDistance) {
		super(name, maxDistance, OperatingEnvironment.WATER);
	}
}
