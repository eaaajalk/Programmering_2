package studentpersist.setup;

import studentpersist.application.controller.Controller;

public class StorageInitializer {

	public static void main(String[] args) {
		initStorage();
	}

	/**
	 * Initializes the storage with some objects.
	 */
	private static void initStorage() {
		Controller controller = Controller.getController();
		controller.createStudent("Lene", 22, true);
		controller.createStudent("Mette", 20, false);
		controller.createStudent("Hans", 23, true);
		controller.createStudent("Mads", 19, false);

		controller.saveStorage();
	}

}
