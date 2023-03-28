package p2.model;

public abstract class LandVehicle extends VehicleBase {

	public LandVehicle(String name, int maxDistance) {
		super(name, maxDistance, OperatingEnvironment.LAND);
		// TODO Auto-generated constructor stub
	}
	@Override
	public OperatingEnvironment getOperatingEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOperatingEnvironment(OperatingEnvironment env) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean canOperateOn(OperatingEnvironment env) {
		return false;
	}
}
