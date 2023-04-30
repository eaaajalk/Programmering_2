package architecture1Semester.storage;

import java.util.ArrayList;

import architecture1Semester.application.model.Company;
import architecture1Semester.application.model.Employee;

public class Storage {
	private static Storage storage = null;
	private static ArrayList<Company> companies = new ArrayList<>();
	private static ArrayList<Employee> employees = new ArrayList<>();

	private Storage(){}

	private static Storage getStorage() {
		if (storage == null){
			storage = new Storage();
		}
		return storage;
	}

	// -------------------------------------------------------------------------

	public static ArrayList<Company> getCompanies() {
		return new ArrayList<Company>(companies);
	}

	public static void addCompany(Company company) {
		companies.add(company);
	}

	public static void removeCompany(Company company) {
		companies.remove(company);
	}

	// -------------------------------------------------------------------------

	public static ArrayList<Employee> getEmployees() {
		return new ArrayList<Employee>(employees);
	}

	public static void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public static void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	// -------------------------------------------------------------------------

}
