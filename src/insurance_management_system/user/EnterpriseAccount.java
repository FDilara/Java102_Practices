package insurance_management_system.user;

import insurance_management_system.insurance.Insurance;

public class EnterpriseAccount extends Account {
    private String companyName;
    public EnterpriseAccount(User user, String companyName) {
        super(user);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
