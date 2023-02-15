package patika_clone;

import patika_clone.model.User;
import patika_clone.view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String studentMenu = """
                1.All Courses\s
                2.Course Registration\s
                3.Comment For Course""";
        String educatorMenu = """
                1.All Courses\s
                2.My Courses\s
                3.Add Quiz Question For Course\s
                4.Add YouTube Link For Course""";
        String operatorMenu = """
                1.All Courses\s
                2.Add Course\s
                3.Assign Educator To Course""";

        SignIn signIn = new SignIn();
        if(signIn.signIn()) {
            Login login = new Login();
            User user = login.login();
            switch (user.getType()) {
                case "Student":
                    System.out.println(studentMenu);
                    System.out.println("Enter the choice:");
                    int studentChoice = input.nextInt();
                    if(studentChoice==1) {
                        Operator.courseList();
                    } else if(studentChoice==2) {
                        Student.register();
                    } else if(studentChoice==3) {
                        Student.comment();
                    }
                    break;
                case "Educator":
                    System.out.println(educatorMenu);
                    System.out.println("Enter the choice:");
                    int educatorChoice = input.nextInt();
                    if(educatorChoice==1) {
                        Operator.courseList();
                    } else if(educatorChoice==2) {
                        Educator.myCourse();
                    } else if(educatorChoice==3) {
                        Educator.addQuestion();
                    } else if(educatorChoice==4) {
                        Educator.addLink();
                    }
                    break;
                case "Operator":
                    System.out.println(operatorMenu);
                    System.out.println("Enter the choice:");
                    int operatorChoice = input.nextInt();
                    if(operatorChoice==1) {
                        Operator.courseList();
                    } else if(operatorChoice==2){
                        Operator.addCourse();
                    } else if(operatorChoice==3){
                        Operator.educatorOfCourse();
                    }
                    break;
                default:
                    System.out.println("User not found!");
                    break;
            }
        }

    }
}
