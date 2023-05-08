package net.heydel.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VehicleBindingAdapter {
	private IntegerProperty maxDistance;
	private BooleanProperty available;
	private StringProperty name;
	private ObjectProperty<OperatingEnvironment> environment;
	private VehicleBase vehicleBase;

	public VehicleBindingAdapter(VehicleBase vehicleBase) {
		this.vehicleBase = vehicleBase;
		this.maxDistance = new SimpleIntegerProperty(vehicleBase.getMaxDistance());
		this.available = new SimpleBooleanProperty(vehicleBase.isAvailable());
		this.name = new SimpleStringProperty(vehicleBase.getName());
		this.environment = new SimpleObjectProperty<OperatingEnvironment>(vehicleBase.getOperatingEnvironment());
	}

	public final IntegerProperty maxDistanceProperty() {
		return this.maxDistance;
	}

	public final int getMaxDistance() {
		return this.maxDistanceProperty().get();
	}

	public final void setMaxDistance(final int maxDistance) {
		this.maxDistanceProperty().set(maxDistance);
		vehicleBase.setMaxDistance(maxDistance);
	}

	public final BooleanProperty availableProperty() {
		return this.available;
	}

	public final boolean isAvailable() {
		return this.availableProperty().get();
	}

	public final void setAvailable(final boolean available) {
		this.availableProperty().set(available);
		vehicleBase.setAvailable(available);
	}

	public final StringProperty nameProperty() {
		return this.name;
	}

	public final String getName() {
		return this.nameProperty().get();
	}

	public final void setName(final String name) {
		this.nameProperty().set(name);
		vehicleBase.setName(name);
	}

	public final ObjectProperty<OperatingEnvironment> environmentProperty() {
		return this.environment;
	}

	public final OperatingEnvironment getEnvironment() {
		return this.environmentProperty().get();
	}

	public final void setEnvironment(final OperatingEnvironment environment) {
		this.environmentProperty().set(environment);
		vehicleBase.setOperatingEnvironment(environment);
	}

	public VehicleBase getVehicleBase() {
		return vehicleBase;
	}

	public void update(VehicleBase vehicleBase) {
		this.vehicleBase = vehicleBase;
		this.maxDistance = new SimpleIntegerProperty(vehicleBase.getMaxDistance());
		this.available = new SimpleBooleanProperty(vehicleBase.isAvailable());
		this.name = new SimpleStringProperty(vehicleBase.getName());
		this.environment = new SimpleObjectProperty<OperatingEnvironment>(vehicleBase.getOperatingEnvironment());
	}
}
