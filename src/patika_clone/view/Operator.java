package patika_clone.view;

import patika_clone.helper.DBConnector;
import patika_clone.model.Course;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.*;

public class Operator {
    public static final Scanner input = new Scanner(System.in);

    public static ArrayList<Course> courses = new ArrayList<>();

    public static void addCourse() {
        System.out.println("Enter the title");
        String title = input.nextLine();
        System.out.println("Enter the explanation");
        String explanation = input.nextLine();
        System.out.println("Enter the lesson");
        String lesson = input.nextLine();

        Course course = new Course(title, explanation, lesson);
        courses.add(course);

        String query = "INSERT INTO course (title, explanation, link, lesson, educator, questions, students, comment) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, title);
            pr.setString(2, explanation);
            pr.setString(3, null);
            pr.setString(4, lesson);
            pr.setString(5, null);
            pr.setArray(6, null);
            pr.setArray(7, null);
            pr.setString(8, null);

            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void educatorOfCourse() {

        System.out.println("Enter the course title:");
        String courseTitle = input.nextLine();
        System.out.println("Enter the educator name:");
        String educator = input.nextLine();

        String query = "UPDATE course SET educator=? WHERE title=?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, educator);
            pr.setString(2, courseTitle);

            pr.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void courseList() {
        courses.forEach(course -> System.out.println("Name: " + course.getLesson() + "Educator: " + course.getEducator()));
    }

}
