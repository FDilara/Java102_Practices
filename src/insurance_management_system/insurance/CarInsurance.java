package insurance_management_system.insurance;

import java.time.LocalDate;

public class CarInsurance extends Insurance {
    public CarInsurance(String name, double fee, LocalDate startDate, LocalDate finishDate) {
        super(name, fee, startDate, finishDate);
    }

    @Override
    public double calculate() {
        return this.getFee();
    }
}
