package net.heydel.view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import net.heydel.VehicleBookingMainApp;
import net.heydel.model.Customer;
import net.heydel.model.OperatingEnvironment;
import net.heydel.model.Vehicle;
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
	private RadioButton air = new RadioButton();
	@FXML
	private RadioButton land = new RadioButton();
	@FXML
	private RadioButton water = new RadioButton();
	@FXML
	private ToggleGroup a = new ToggleGroup();
	@FXML
	private Label availableVehicles;

	private VehicleBookingMainApp mainApp;

	private Customer customer;

	private VehicleManagement vMan;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setVMan(VehicleManagement vMan) {
		this.vMan = vMan;
		availableVehicles.setText(Integer.toString(vMan.countAvailableVehicles()));
	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		maxDistanceColumn.setCellValueFactory(cellData -> cellData.getValue().maxDistanceProperty().asObject());
		availableColumn.setCellValueFactory(cellData -> cellData.getValue().availableProperty().asObject());
		environmentColumn.setCellValueFactory(cellData -> cellData.getValue().environmentProperty());
		air.setUserData(OperatingEnvironment.AIR);
		air.setToggleGroup(a);
		land.setUserData(OperatingEnvironment.LAND);
		land.setToggleGroup(a);
		water.setUserData(OperatingEnvironment.WATER);
		water.setToggleGroup(a);
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
	private void handleSearch() throws NumberFormatException, NullPointerException {
		int distance;
		OperatingEnvironment env;
		try {
			distance = Integer.parseInt(searchDistance.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ungültige Eingabe");
			alert.setHeaderText("Die Eingabe für die minimale Distanz war ungültig.");
			alert.setContentText("Bitte verwenden Sie nur die Ziffern 1 bis 9.");
			alert.showAndWait();
			distance = Integer.MAX_VALUE;
		}
		try {
			env = (OperatingEnvironment) a.getSelectedToggle().getUserData();
		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ungültige Eingabe");
			alert.setHeaderText("Die wählen Sie einen Fahrzeugtypen aus.");
			alert.showAndWait();
			env = null;
		}
		List<Vehicle> temp = vMan.findMatchingVehicles(distance, env);
		ObservableList<VehicleBindingAdapter> vehicleDataTemp = FXCollections.observableArrayList();
		for (Vehicle v : temp) {
			vehicleDataTemp.add(v.getAdapter());
		}
		vehicleData.setItems(vehicleDataTemp);
	}

	@FXML
	private void handleShowAll() {
		vehicleData.setItems(this.mainApp.getVehicleData());
	}

	@FXML
	private void handleBook() throws IOException {
		VehicleBindingAdapter v = vehicleData.getSelectionModel().selectedItemProperty().getValue();
		if (v != null) {
			try {
				if (!vMan.bookVehicle(v.getVehicleBase(), customer)) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Invalid Vehicle");
					alert.setHeaderText("The vehicle is already booked.");
					alert.setContentText("Please select another vehicle.");
					alert.showAndWait();
				} else {
					vehicleData.refresh();
					availableVehicles.setText(Integer.toString(vMan.countAvailableVehicles()));

				}
			} catch (IOException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler beim logen der Buchung");
				alert.setHeaderText("Fehler beim logen der Buchung.");
				alert.setContentText("Bitte versuchen Sie es erneut.");
				alert.showAndWait();
				new File("./logfile.txt").createNewFile();
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
