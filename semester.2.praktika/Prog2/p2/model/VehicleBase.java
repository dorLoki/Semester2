package p2.model;

public abstract class VehicleBase implements Vehicle {
	private int maxDistance;
	private boolean available;
	private String name;
	private OperatingEnvironment operatingEnvironment;

	public VehicleBase(String name, int maxDistance, OperatingEnvironment env) {
		this.name = name;
		this.maxDistance = maxDistance;
	}

	@Override
	public abstract OperatingEnvironment getOperatingEnvironment();

	public abstract void setOperatingEnvironment(OperatingEnvironment env);

	@Override
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean b) {
		this.available = b;
	}

	@Override
	public int getMaxDistance() {
		return this.maxDistance;
	}

	public void setMaxDistance(int d) {
		this.maxDistance = d;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public abstract boolean canOperateOn(OperatingEnvironment env);

	@Override
	public void book() {
	}
}
