package net.heydel.model;

public interface Vehicle {
	boolean isAvailable();

	int getMaxDistance();

	OperatingEnvironment getOperatingEnvironment();

	String getName();

	void book();

	boolean canOperateOn(OperatingEnvironment environment);
	
	public VehicleBindingAdapter getAdapter();
}
