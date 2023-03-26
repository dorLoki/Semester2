package p2.model;

public abstract class VehicleBase implements Vehicle{
	private int maxDistance;
	private boolean available;
	private String name;
	public VehicleBase(String name, int maxDistance, OperatingEnvironment env) {
		this.name = name;
		this.maxDistance = maxDistance;
	}
	@Override
	public OperatingEnvironment getOperatingEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setOperatingEnvironment(OperatingEnvironment env) {
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean b) {
		this.available = b;
	}
	public int getMaxDistance() {
		return this.maxDistance;
	}
	public void setMaxDistance(int d) {
		this.maxDistance = d;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean canOperateOn(OperatingEnvironment env) {
		return false;
	}
	public void book() {
		
	}
}
