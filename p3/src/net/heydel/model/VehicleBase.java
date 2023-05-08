package net.heydel.model;


public abstract class VehicleBase implements Vehicle {
	private int maxDistance;
	private boolean available = true;
	private String name;
	private OperatingEnvironment environment;
	private VehicleBindingAdapter adapter;

	public VehicleBindingAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(VehicleBindingAdapter adapter) {
		this.adapter = adapter;
	}

	public void notifyAdapter() {
		adapter.update(this);
	}
	
	public VehicleBase(String name, int distance, OperatingEnvironment environment) {
		super();
		this.name = name;
		this.maxDistance = distance;
		this.environment = environment;
	}

	public OperatingEnvironment getOperatingEnvironment() {
		return environment;
	}

	public void setOperatingEnvironment(OperatingEnvironment environment) {
		if (!this.environment.equals(environment)) {
			this.environment = environment;
		}
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		if (this.available != available) {
			this.available = available;
		}
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int distance) {
		if (this.maxDistance != distance) {
			this.maxDistance = distance;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!this.name.equals(name)) {
			this.name = name;
		}
	}

	public boolean canOperateOn(OperatingEnvironment environment) {
		if (environment == this.environment) {
			return true;
		}
		return false;
	}

	public void book() {
		setAvailable(false);
		notifyAdapter();
	}
}
