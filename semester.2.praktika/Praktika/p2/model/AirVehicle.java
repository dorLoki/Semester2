package p2.model;

public abstract class AirVehicle extends VehicleBase {
	public AirVehicle(String name, int maxDistance) {
		super(name, maxDistance, OperatingEnvironment.AIR);
	}
}
