package p9;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
	public static void main(String[] args) {
		new Main();
	}

	private ArrayList<Player> players = new ArrayList<Player>();

	public Main() {
		Spielleiter s = new Spielleiter();
		for (int i = 0; i < 10; i++) {
			players.add(new Player());
		}
		s.start();
	}

	private class Spielleiter extends Thread {
		@Override
		public void run() {
			for (Player player : players) {
				try {
					//Future<Integer> t = player.get();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private class Player implements RunnableFuture<Integer> {
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCancelled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isDone() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer get() throws InterruptedException, ExecutionException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Integer get(long timeout, TimeUnit unit)
				throws InterruptedException, ExecutionException, TimeoutException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
}
