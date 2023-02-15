package insurance_management_system.insurance;

import insurance_management_system.insurance.Insurance;

import java.time.LocalDate;

public class HealthInsurance extends Insurance {
    public HealthInsurance(String name, double fee, LocalDate startDate, LocalDate finishDate) {
        super(name, fee, startDate, finishDate);
    }

    @Override
    public double calculate() {
        return this.getFee();
    }
}
