package insurance_management_system.user;

import java.util.ArrayList;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accountList = new TreeSet<>(new Account());

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void deleteAccount(Account account) {
        accountList.remove(account);
    }

    public Account login(String email, String password) {
        for (Account account : accountList) {
            try {
                account.login(email, password);
                if (account.getAuthenticationStatus() == Account.AuthenticationStatus.SUCCESS) {
                    return account;
                }
            } catch (InvalidAuthenticationException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public ArrayList<User> getAccountList() {
        ArrayList<User> userList = new ArrayList<>();
        accountList.forEach(account -> userList.add(account.getUser()));
        return userList;
    }

}
