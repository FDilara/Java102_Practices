package collection_tree_set;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //According to student note

        //TreeSet<Student> students = new TreeSet<>(new OrderNoteComparator()); //small to big
        //TreeSet<Student> students = new TreeSet<>(new OrderNoteComparator().reversed()); //big to small

        //According to student name

        //TreeSet<Student> students = new TreeSet<>(new OrderNameComparator());
        TreeSet<Student> students = new TreeSet<>(new OrderNameComparator().reversed());

        students.add(new Student("Ayşe", 90));
        students.add(new Student("Fatma", 80));
        students.add(new Student("Ali", 70));
        students.add(new Student("Ahmet", 60));

        for (Student student: students) {
            System.out.println(student.getName());
        }
    }
}
