package studentpersist.gui;

import studentpersist.application.controller.Controller;
import studentpersist.application.model.Student;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartWindow extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Administrer studerende");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private CheckBox chkActive;
	private ListView<Student> lvwStudents;

	private Button btnAdd;
	private Button btnSave;
	private Button btnDelete;

	private Controller controller;

	

	private void initContent(GridPane pane) {
		controller = Controller.getController();
		controller.loadStorage();

		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		Label lblName = new Label("Navn");
		pane.add(lblName, 1, 1);
		Label lblActive = new Label("Aktiv");
		pane.add(lblActive, 1, 3);

		txfName = new TextField();
		pane.add(txfName, 2, 1, 4, 1);

		chkActive = new CheckBox();
		pane.add(chkActive, 2, 3);

		// add a buttons to the pane

		btnAdd = new Button("Opret");
		pane.add(btnAdd, 1, 5);
		btnSave = new Button("Gem");
		btnSave.setDisable(true);
		pane.add(btnSave, 2, 5);

		btnDelete = new Button("Slet");
		pane.add(btnDelete, 3, 5);
		btnDelete.setDisable(true);

		// connect a method to the button

		btnAdd.setOnAction(event -> addAction());
		btnSave.setOnAction(event -> saveAction());

		btnDelete.setOnAction(event -> deleteAction());

		lvwStudents = new ListView<>();
		pane.add(lvwStudents, 0, 1, 1, 3);
		lvwStudents.setPrefWidth(250);
		lvwStudents.setPrefHeight(200);
		lvwStudents.getItems().setAll(controller.getStudents());

		ChangeListener<Student> listener = (ov, oldCompny, newCompany) -> selectedStudentChanged();
		lvwStudents.getSelectionModel().selectedItemProperty().addListener(listener);

	}

	@Override
	public void stop() {
		controller.saveStorage();
	}

	/**
	 * This class controls access to the model in this application. In this
	 * case, the model is a single Student object.
	 */

		private Student studerende = null;

		private void addAction() {

			studerende = controller.createStudent(txfName.getText().trim(), 20, chkActive.isSelected());
			clearFields();

			btnAdd.setDisable(true);
			lvwStudents.getItems().setAll(controller.getStudents());

		}

		private void saveAction() {
			if (studerende != null) {
				controller.updateStudent(studerende, txfName.getText().trim(), 20, chkActive.isSelected());
				clearFields();

				btnSave.setDisable(true);
				btnDelete.setDisable(true);

				lvwStudents.getItems().setAll(controller.getStudents());

			}

		}

		private void deleteAction() {
			if (studerende != null) {
				controller.deleteStudent(studerende);
				studerende = null;
				clearFields();
				btnDelete.setDisable(true);
				btnSave.setDisable(true);

				btnAdd.setDisable(false);
				lvwStudents.getItems().setAll(controller.getStudents());

			}

		}

		private void clearFields() {
			txfName.clear();
			chkActive.setSelected(false);
		}

		private void selectedStudentChanged() {
			studerende = lvwStudents.getSelectionModel().getSelectedItem();
			if (studerende != null) {
				txfName.setText(studerende.getName());
				chkActive.setSelected(studerende.isActive());

				btnSave.setDisable(false);
				btnDelete.setDisable(false);
			}
		}
	
}
