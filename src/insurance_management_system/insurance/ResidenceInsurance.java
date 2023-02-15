package insurance_management_system.insurance;

import java.time.LocalDate;

public class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(String name, double fee, LocalDate startDate,LocalDate finishDate) {
        super(name, fee, startDate, finishDate);
    }

    @Override
    public double calculate() {
        return 0;
    }
}
