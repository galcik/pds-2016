package sk.upjs.pds;

import java.util.*;

/**
 * Spravca workerov
 */
public class TaskMaster {

	/**
	 * Zoznam worker vlakien.
	 */
	private final List<Worker> workers;

	/**
	 * Vytvori spravcu workerov.
	 */
	public TaskMaster() {
		workers = new ArrayList<Worker>();
	}

	public void startJobs() {
		for (int i = 0; i < 6; i++) {
			workers.add(new Worker(i, this));
		}

		for (Worker worker : workers) {
			worker.start();
		}
	}

	public static void main(String[] args) {
		TaskMaster master = new TaskMaster();
		master.startJobs();
	}
}
