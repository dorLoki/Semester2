package net.heydel;

import java.io.IOException;
import java.util.Iterator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import net.heydel.model.Customer;
import net.heydel.model.Jetski;
import net.heydel.model.Plane;
import net.heydel.model.SUV;
import net.heydel.model.Vehicle;
import net.heydel.model.VehicleBase;
import net.heydel.model.VehicleBindingAdapter;
import net.heydel.model.VehicleManagement;
import net.heydel.view.VehicleBookingController;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class VehicleBookingMainApp extends Application {
	private Stage primaryStage;
	private VBox rootLayout;

	private VehicleManagement vMan;
	private Customer customer;

	/**
	 * The data as an observable list of vehicle.
	 */
	private ObservableList<VehicleBindingAdapter> vehicleData = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Booking App");
		// this.primaryStage.getIcons().add(new Image("file:res/img/icon.png"));
		initRootLayout();

	}

	public VehicleBookingMainApp() {
		// Add some sample data TODO
		customer = new Customer(0, "Bob");
		vMan = new VehicleManagement();
		SUV suv = new SUV("Krasser SUV", 600);
		Plane plane = new Plane("Krasses Flugzeug", 6000);
		Jetski jetski = new Jetski("Krasser Jetski", 100);
		VehicleBindingAdapter a = new VehicleBindingAdapter(suv);
		VehicleBindingAdapter b = new VehicleBindingAdapter(plane);
		VehicleBindingAdapter c = new VehicleBindingAdapter(jetski);
		suv.setAdapter(a);
		plane.setAdapter(b);
		jetski.setAdapter(c);
		vMan.addVehicle(a.getVehicleBase());
		vMan.addVehicle(b.getVehicleBase());
		vMan.addVehicle(c.getVehicleBase());
		vehicleData.add(a);
		vehicleData.add(b);
		vehicleData.add(c);

	}

	/**
	 * Returns the data as an observable list of Persons.
	 * 
	 * @return
	 */
	public ObservableList<VehicleBindingAdapter> getVehicleData() {
		return vehicleData;
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VehicleBookingMainApp.class.getResource("view/BookingOverview.fxml"));
			rootLayout = (VBox) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			VehicleBookingController controller = loader.getController();
			controller.setMainApp(this);
			controller.setCustomer(customer);
			controller.setVMan(vMan);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public VehicleManagement getVMan() {
		return vMan;
	}

	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
