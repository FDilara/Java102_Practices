package patika_clone.view;

import patika_clone.helper.DBConnector;
import patika_clone.model.Course;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
    public static final Scanner input = new Scanner(System.in);

    public static void register() {

        System.out.println("Enter the course title:");
        String courseTitle = input.nextLine();
        System.out.println("Enter the student name:");
        String student = input.nextLine();

        Course.students.add(student);

        String query = "UPDATE course SET student=? WHERE title=?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setArray(1, (Array) Course.students);
            pr.setString(2, courseTitle);

            pr.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void comment() {

        System.out.println("Enter the course title:");
        String courseTitle = input.nextLine();
        System.out.println("Enter the comment:");
        String comment = input.nextLine();

        Course.comment = comment;

        String query = "UPDATE course SET comment=? WHERE title=?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, comment);
            pr.setString(2, courseTitle);

            pr.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
