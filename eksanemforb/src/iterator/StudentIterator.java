package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentIterator implements Iterator<Student> {
    private ArrayList<Student> list = new ArrayList<>();
    private int position = 0;

    public StudentIterator(ArrayList<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student student = list.get(position);
        position++;
        return student;
    }
}
