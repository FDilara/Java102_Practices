package patika_clone.view;

import patika_clone.helper.DBConnector;
import patika_clone.model.User;

import java.util.Scanner;

import java.sql.*;

public class SignIn {

    private static final Scanner input = new Scanner(System.in);

    public boolean signIn() {
        boolean status = false;

        System.out.println("Name: ");
        String name = input.nextLine();
        System.out.println("User Name: ");
        String uname = input.nextLine();
        System.out.println("Password: ");
        String pass = input.nextLine();
        System.out.println("Password (Again): ");
        String passAgain = input.nextLine();
        System.out.println("Type: ");
        String type = input.nextLine();

        if(name==null || uname==null || pass==null || passAgain==null || type==null){
            System.out.println("Enter all fields!");
            status = false;
        } else {
            if(passAgain.equals(pass)) {
                if(addUser(name,uname,pass,type)) {
                    System.out.println("User added successfully.");
                    status = true;
                }
            }
        }

        return status;

    }

    private boolean addUser(String name, String uname, String pass, String type){

        String query = "INSERT INTO users (name,u_name,pass,type) VALUES (?,?,?,?)";

        User findUser = User.getUser(uname, pass);
        if (findUser != null){
            System.out.println("This username has been taken. Please enter a different user.");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(3,pass);
            pr.setString(4,type);


            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

}
