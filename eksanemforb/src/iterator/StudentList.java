package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList implements Iterable<Student> {
    private ArrayList<Student> list = new ArrayList<>();

    public StudentList() {
    }
    public void addStudent(Student student) {
        if (!list.contains(student)) {
            list.add(student);
        }
    }
    public void removeStudent(Student student) {
        list.remove(student);
    }
    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(list);
    }
}
