package p2.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	private VehicleManagement vMan;
	private Vehicle v1, v2, v3, v4, v5, v6, v7;
	private Customer c1, c2, c3;

	@BeforeEach
	void setUp() throws Exception {
		vMan = new VehicleManagement();
		c1 = new Customer(1, "Bob");
		c2 = new Customer(2, "Alice");
		c3 = new Customer(3, "Max");
		v1 = new Boat("Yacht", 1000);
		v2 = new ECar("Tesla", 600);
		v3 = new Helicopter("UH-1H", 700);
		v4 = new Jetski("Jetski oder so", 150);
		v5 = new Plane("F-16", 4000);
		v6 = new SUV("Krasser SUV", 800);
		v7 = new SUV("Noch Krasserer SUV", 1000);
		vMan.addVehicle(v1);
		vMan.addVehicle(v2);
		vMan.addVehicle(v3);
		vMan.addVehicle(v4);
		vMan.addVehicle(v5);
		vMan.addVehicle(v6);
		vMan.addVehicle(v7);
		c1.setVehicleManagement(vMan);
		c2.setVehicleManagement(vMan);
		c3.setVehicleManagement(vMan);
	}

	@org.junit.jupiter.api.Test
	void testBookVehicle() {
		assertEquals(vMan.bookVehicle(v1, c1), true);
	}

	@org.junit.jupiter.api.Test
	void testBookVehicleNull() {
		assertEquals(vMan.bookVehicle(null, c1), false);
	}

	@org.junit.jupiter.api.Test
	void testBookNotAvailableVehicle() {
		assertEquals(vMan.bookVehicle(new SUV("d", 0), c1), false);
	}

	@org.junit.jupiter.api.Test
	void testFindMatchingVehicles() {
		assertEquals(vMan.findMatchingVehicles(0, OperatingEnvironment.WATER),
				new ArrayList<Vehicle>(Arrays.asList(v1, v4)));
	}

	@org.junit.jupiter.api.Test
	void testFindMatchingVehiclesIfNull() {
		assertEquals(vMan.findMatchingVehicles(0, null), new ArrayList<Vehicle>());
	}
	@org.junit.jupiter.api.Test
	void testEnvironmentOfBoat() {
		assertEquals(v1.getOperatingEnvironment(), OperatingEnvironment.WATER);
	}
	@org.junit.jupiter.api.Test
	void testMaxDistanceOfBoat() {
		assertEquals(v1.getMaxDistance(), 1000);
	}
	@org.junit.jupiter.api.Test
	void testNameOfBoat() {
		assertEquals(v1.getName(), "Yacht");
	}
	

	@org.junit.jupiter.api.Test
	void test2() {
		c1.searchAndBookVehicle(700, OperatingEnvironment.AIR);
		assertEquals(v3.isAvailable(), false);
	}

	@org.junit.jupiter.api.Test
	void test3() {
		assertEquals(v3.isAvailable(), true);
	}

	@org.junit.jupiter.api.Test
	void test4() {
		c1.searchAndBookVehicle(700, OperatingEnvironment.AIR);
		Map<Integer, ArrayList<Vehicle>> bookedVehicleRes = new HashMap<Integer, ArrayList<Vehicle>>();
		bookedVehicleRes.put(1, new ArrayList<Vehicle>(Arrays.asList(v3)));
		c2.searchAndBookVehicle(700, OperatingEnvironment.AIR);
		bookedVehicleRes.put(2, new ArrayList<Vehicle>(Arrays.asList(v5)));
		c3.searchAndBookVehicle(700, OperatingEnvironment.AIR);
		// assertEquals(vMan.bookedVehicle, bookedVehicleRes);
	}

	@org.junit.jupiter.api.Test
	void test5() {
		assertEquals(c1.getName(), "Bob");
	}

	@org.junit.jupiter.api.Test
	void test6() {
		assertEquals(c1.getID(), 1);
	}
}
