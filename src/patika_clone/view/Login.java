package patika_clone.view;

import patika_clone.model.User;

import java.util.Scanner;

public class Login {
    private static final Scanner input = new Scanner(System.in);
    public User login() {

        System.out.println("User Name: ");
        String uname = input.nextLine();
        System.out.println("Password: ");
        String pass = input.nextLine();

        User user =null;

        if (uname==null || pass==null){
            System.out.println("Enter all fields!");
        }else{
            user = User.getUser(uname,pass);
            if (user == null) {
                System.out.println("User not found!");
            }
        }
        return user;
    }
}
