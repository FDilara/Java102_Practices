package insurance_management_system.address;

import insurance_management_system.user.User;

public class AddressManager {
    private User user;

    public AddressManager(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void add(Address address) {
        getUser().getAddressList().add(address);
    }

    public void delete(Address address) {
        getUser().getAddressList().remove(address);
    }


}
