package insurance_management_system;

import insurance_management_system.address.Address;
import insurance_management_system.address.AddressManager;
import insurance_management_system.address.BusinessAddress;
import insurance_management_system.address.HomeAddress;
import insurance_management_system.insurance.CarInsurance;
import insurance_management_system.insurance.HealthInsurance;
import insurance_management_system.insurance.ResidenceInsurance;
import insurance_management_system.insurance.TravelInsurance;
import insurance_management_system.user.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static AccountManager accountManager = new AccountManager();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String menu = """
                Management Panel:\s
                1.Add User (Individual or Enterprise)\s
                2.Login\s
                3.Show List Accounts\s
                4.Exit""";

        String loginMenu = """
                1.Add Address\s
                2.Add Insurance\s
                3.Show User Info\s
                4.Logout""";

        String insuranceMenu = """
                1.Car Insurance\s
                2.Health Insurance\s
                3.Residence Insurance\s
                4.Travel Insurance""";

        int choice;
        int choiceLoginOperation;
        do {
            System.out.println(menu);
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter user type (Individual or Enterprise) (I/E): ");
                    input.nextLine();
                    String userType = input.nextLine();
                    System.out.print("Enter user name: ");
                    String name = input.nextLine();
                    System.out.print("Enter user last name: ");
                    String lastname = input.nextLine();
                    System.out.print("Enter user email: ");
                    String email = input.nextLine();
                    System.out.print("Enter user password: ");
                    String password = input.nextLine();
                    System.out.print("Enter user job: ");
                    String job = input.nextLine();
                    System.out.print("Enter user age: ");
                    int age = input.nextInt();
                    String companyName = null;
                    if (userType.equalsIgnoreCase("E")) {
                        System.out.print("Enter your company name: ");
                        input.nextLine();
                        companyName = input.nextLine();
                    }
                    addUser(userType, name, lastname, email, password, job, age, companyName);
                    break;
                case 2:
                    System.out.print("Enter user email: ");
                    input.nextLine();
                    String userEmail = input.nextLine();
                    System.out.print("Enter user password: ");
                    String userPassword = input.nextLine();
                    Account account = userLogin(userEmail, userPassword);
                    if (account == null) {
                        System.out.println("Login failed!");
                    } else {
                        System.out.println("Login successful!");

                        do {
                            System.out.println(loginMenu);
                            System.out.println("Enter your choice: ");
                            choiceLoginOperation = input.nextInt();
                            switch (choiceLoginOperation) {
                                case 1:
                                    System.out.println("1. Home Address");
                                    System.out.println("2. Business Address");
                                    System.out.print("Enter your choice: ");
                                    int addressChoice = input.nextInt();
                                    input.nextLine();
                                    System.out.print("Enter your country: ");
                                    String country = input.nextLine();
                                    System.out.print("Enter your city: ");
                                    String city = input.nextLine();
                                    System.out.print("Enter your street: ");
                                    String street = input.nextLine();
                                    assert account != null;
                                    addAddress(account.getUser(), addressChoice, country, city, street);
                                    break;
                                case 2:
                                    System.out.println(insuranceMenu);
                                    System.out.print("Enter your choice: ");
                                    int insuranceChoice = input.nextInt();
                                    assert account != null;
                                    if (insuranceChoice == 1) {
                                        CarInsurance carInsurance = new CarInsurance("Car Insurance", 1500.0, LocalDate.now(), LocalDate.now().minusYears(1));
                                        account.addInsurances(carInsurance);
                                    } else if (insuranceChoice == 2) {
                                        HealthInsurance healthInsurance = new HealthInsurance("Health Insurance", 2500.0, LocalDate.now(), LocalDate.now().minusYears(1));
                                        account.addInsurances(healthInsurance);
                                    } else if (insuranceChoice == 3) {
                                        ResidenceInsurance residenceInsurance = new ResidenceInsurance("Residence Insurance", 3500.0, LocalDate.now(), LocalDate.now().minusYears(1));
                                        account.addInsurances(residenceInsurance);
                                    } else {
                                        TravelInsurance travelInsurance = new TravelInsurance("Travel Insurance", 4500.0, LocalDate.now(), LocalDate.now().minusYears(1));
                                        account.addInsurances(travelInsurance);
                                    }
                                    break;
                                case 3:
                                    account.showUserInfo();
                                    break;
                                case 4:
                                    account = null;
                                    System.out.println("Exiting!");
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                                    break;
                            }
                        } while (choiceLoginOperation < 4);
                    }
                    break;
                case 3:
                    accountManager.getAccountList().forEach(user -> System.out.println("Name: " + user.getName() + " " + user.getLastName() + " - Last Login Date: " + user.getLastDate()));
                    break;
                case 4:
                    System.out.println("Exiting the system");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice < 4);
    }
    public static void addUser(String userType, String name, String lastname, String email, String password, String job, int age, String companyName) {
        User user = new User(name, lastname, email, password, job, age);
        if (userType.equalsIgnoreCase("I")) {
            Account account = new IndividualAccount(user);
            accountManager.addAccount(account);
            System.out.println("User added successfully!");
        } else if (userType.equalsIgnoreCase("E")) {
            Account account = new EnterpriseAccount(user, companyName);
            accountManager.addAccount(account);
            System.out.println("User added successfully!");
        }
    }

    public static Account userLogin(String userEmail, String userPassword) {
        Account account = accountManager.login(userEmail, userPassword);
        if (account != null)
            account.showUserInfo();
        return account;
    }

    public static void addAddress(User user, int addressChoice, String country, String city, String street) {
        AddressManager addressManager = new AddressManager(user);
        Address address;
        if (addressChoice == 1) {
            address = new HomeAddress(country, city, street);
            addressManager.add(address);
        } else if (addressChoice == 2) {
            address = new BusinessAddress(country, city, street);
            addressManager.add(address);
        }
    }
}


