package p2.model;

public interface Vehicle {
	public boolean isAvailable();

	public int getMaxDistance();

	public OperatingEnvironment getOperatingEnvironment();

	public String getName();

	public void book();

	public boolean canOperateOn(OperatingEnvironment env);
}
