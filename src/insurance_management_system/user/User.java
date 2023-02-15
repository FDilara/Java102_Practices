package insurance_management_system.user;

import insurance_management_system.address.Address;
import insurance_management_system.insurance.Insurance;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> addressList =  new ArrayList<>();
    private ArrayList<Insurance> insurances = new ArrayList<>();
    private LocalDate lastDate;

    public User(String name, String lastName, String email, String password, String job, int age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.lastDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }
}
