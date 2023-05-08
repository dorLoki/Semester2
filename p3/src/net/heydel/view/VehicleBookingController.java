package net.heydel.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import net.heydel.VehicleBookingMainApp;
import net.heydel.model.Customer;
import net.heydel.model.OperatingEnvironment;
import net.heydel.model.VehicleBindingAdapter;
import net.heydel.model.VehicleManagement;

public class VehicleBookingController {

	@FXML
	private TableView<VehicleBindingAdapter> vehicleData;
	@FXML
	private TableColumn<VehicleBindingAdapter, String> nameColumn;
	@FXML
	private TableColumn<VehicleBindingAdapter, Integer> maxDistanceColumn;
	@FXML
	private TableColumn<VehicleBindingAdapter, Boolean> availableColumn;
	@FXML
	private TableColumn<VehicleBindingAdapter, OperatingEnvironment> environmentColumn;
	@FXML
	private TextField searchDistance;
	@FXML
	private RadioButton air;
	@FXML
	private RadioButton land;
	@FXML
	private RadioButton water;
	@FXML
	private ToggleGroup a;

	private VehicleBookingMainApp mainApp;

	private Customer customer;

	private VehicleManagement vMan;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setVMan(VehicleManagement vMan) {
		this.vMan = vMan;
	}

	public VehicleBookingController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		maxDistanceColumn.setCellValueFactory(cellData -> cellData.getValue().maxDistanceProperty().asObject());
		availableColumn.setCellValueFactory(cellData -> cellData.getValue().availableProperty().asObject());
		environmentColumn.setCellValueFactory(cellData -> cellData.getValue().environmentProperty());
		air.setUserData(OperatingEnvironment.AIR);
		land.setUserData(OperatingEnvironment.LAND);
		water.setUserData(OperatingEnvironment.WATER);
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp the main app
	 */
	public void setMainApp(VehicleBookingMainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		vehicleData.setItems(this.mainApp.getVehicleData());
	}

	@FXML
	private void handleSearch() {
		int distance = Integer.parseInt(searchDistance.toString());
		
	}

	@FXML
	private void handleShowAll() {

	}

	@FXML
	private void handleBook() {
		VehicleBindingAdapter v = vehicleData.getSelectionModel().selectedItemProperty().getValue();
		if (v != null) {
			if (!vMan.bookVehicle(v.getVehicleBase(), customer)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid Vehicle");
				alert.setHeaderText("The vehicle is already booked.");
				alert.setContentText("Please select another vehicle.");
				alert.showAndWait();
			} else {
				vehicleData.refresh();
			}
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Vehicle");
			alert.setHeaderText("No Vehicle selected.");
			alert.setContentText("To book a vehicle, you must select one first.");

			alert.showAndWait();

		}
	}
}
