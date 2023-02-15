package insurance_management_system.user;

import insurance_management_system.address.Address;
import insurance_management_system.address.AddressManager;
import insurance_management_system.insurance.Insurance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Account implements Comparator<Account> {

    @Override
    public int compare(Account a1, Account a2) {
        return a1.getUser().getName().compareTo(a2.getUser().getName());
    }

    public enum AuthenticationStatus {
        SUCCESS, FAIL
    }
    private User user;
    protected ArrayList<Insurance> insurances;
    private AuthenticationStatus authenticationStatus;

    public Account() {}

    public Account(User user) {
        this.user = user;
        this.insurances = new ArrayList<>();
        this.authenticationStatus = AuthenticationStatus.FAIL;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Invalid email or password");
        }
    }

    public void addAddress(Address address) {
        if (authenticationStatus == AuthenticationStatus.SUCCESS) {
            AddressManager addressManager = new AddressManager(this.user);
            addressManager.add(address);
        }
    }

    public void removeAddress(Address address) {
        if (authenticationStatus == AuthenticationStatus.SUCCESS) {
            AddressManager addressManager = new AddressManager(this.user);
            addressManager.delete(address);
        }
    }

    public final void showUserInfo() {
        System.out.println("--------------------User Info----------------------");
        System.out.println("Name: " + getUser().getName());
        System.out.println("Surname: " + getUser().getLastName());
        System.out.println("Email: " + getUser().getEmail());
        System.out.println("Password: " + getUser().getPassword());
        System.out.println("Age: " + getUser().getAge());
        getUser().setLastDate(LocalDate.now());
        System.out.println("Last login date: " + getUser().getLastDate());
        if (this instanceof EnterpriseAccount) {
            System.out.println("Company Name: " + ((EnterpriseAccount) this).getCompanyName());
        }
        System.out.println("Addresses: ");
        for (Address address : getUser().getAddressList()) {
            System.out.println("- " + address.getCity());
        }
        System.out.println("Insurances: ");
        for (Insurance insurance : getInsurances()) {
            System.out.println("- " + insurance.getName());
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void addInsurances(Insurance insurances) {
        this.insurances.add(insurances);
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }
}
