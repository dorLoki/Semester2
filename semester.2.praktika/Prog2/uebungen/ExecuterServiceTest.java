package uebungen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceTest {
	public static void main(String[] args) {
		ExecutorService executor = null;
		for (int i = 0; i < 10000; i++) {
			executor = Executors.newFixedThreadPool(1);
			executor.submit(() -> {});
		}
		executor.shutdownNow(); // beendet nur den zuletzt ersellten Thread
	}
}