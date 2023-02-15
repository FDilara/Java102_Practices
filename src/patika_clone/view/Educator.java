package patika_clone.view;

import patika_clone.helper.DBConnector;
import patika_clone.model.Course;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Educator {
    public static final Scanner input = new Scanner(System.in);

    public static void myCourse() {

        System.out.println("Enter the educator:");
        String educator = input.nextLine();

        String query = "SELECT * FROM course WHERE educator= " + educator;

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            ResultSet rs = pr.executeQuery(query);
            if (rs.next()){
                System.out.println(rs.getString("title") + " - " + rs.getArray("students"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addQuestion() {

        System.out.println("Enter the course title:");
        String courseTitle = input.nextLine();
        System.out.println("Enter the question:");
        String question = input.nextLine();

        Course.questions.add(question);

        String query = "UPDATE course SET questions=? WHERE title=?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setArray(1, (Array) Course.questions);
            pr.setString(2, courseTitle);

            pr.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addLink() {

        System.out.println("Enter the course title:");
        String courseTitle = input.nextLine();
        System.out.println("Enter the course link:");
        String link = input.nextLine();

        String query = "UPDATE course SET link=? WHERE title=?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, link);
            pr.setString(2, courseTitle);

            pr.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
