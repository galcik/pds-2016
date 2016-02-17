package sk.upjs.pds;

class Worker extends Thread {

	/**
	 * ID worker vlakna.
	 */
	private final int myId;

	/**
	 * Referencia na spravcu, ktory moze uchovavat napr. nejake uzitocne
	 * synchronizacne objekty (ako modifikator viditelnosti pouzite package
	 * protected).
	 */
	private final TaskMaster master;

	/**
	 * Vytvori worker vlakno
	 * 
	 * @param myId
	 *            identifikator vlakna
	 * @param master
	 *            master, pre ktoreho worker vykonava pracu
	 */
	public Worker(int myId, TaskMaster master) {
		this.myId = myId;
		this.master = master;
	}

	@Override
	public void run() {
		// Periodicky robi pracu a publikuje vysledky.
		while (!isInterrupted()) {
			try {
				doSomeWork();
			} catch (InterruptedException e) {
				break;
			}

			// TODO: zabezpecte:
			// (1) vzajomne vylucenie vsetkych workerov pri volani publishResult
			// (2) workery publikuju vysledky tak, ze poradie vypisov
			// identifikatorov workerov bude cyklicka postupnost 0, 1, 2, ...,
			// n-1, 0, 1, 2, ...
			publishResult();
		}
	}

	/**
	 * Realizuje nejamu pracu. Zakaz modifikovat!
	 */
	private void doSomeWork() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 10000));
	}

	/**
	 * Opublikuje vysledok (v najjednoduchsej forme ako vypis). Zakaz
	 * modifikovat!
	 */
	private void publishResult() {
		System.out.println("Result from: " + myId);
	}
}
