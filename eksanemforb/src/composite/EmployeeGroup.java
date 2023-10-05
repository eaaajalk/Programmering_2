package composite;

import java.util.ArrayList;

public class EmployeeGroup extends Employee {
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeGroup(String navn, String stilling) {
        super(navn, stilling);
    }

    public void addEmployee (Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void removeEmployee (Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
    }
    public String displayDetails() {
        String res = "";
        for (int i = 0; i < employees.size(); i++) {
            res = employees.get(i).displayDetails() + "\n";
        }
        return res;
    }
}
