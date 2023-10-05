package iterator;

import java.util.Iterator;

public class app {

    public static void main(String[] args) {
        Student s1 = new Student("Jakob", 27);
        Student s2 = new Student("Hans", 30);
        Student s3 = new Student("Helge", 27);

        StudentList studentList = new StudentList();
        studentList.addStudent(s1);
        studentList.addStudent(s2);
        studentList.addStudent(s3);

        for (Student student : studentList) {
            System.out.println(student.getNavn());
        }
    }
}
