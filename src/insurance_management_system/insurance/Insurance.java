package insurance_management_system.insurance;

import java.time.LocalDate;

public abstract class Insurance {
    private String name;
    private double fee;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Insurance(String name, double fee, LocalDate startDate, LocalDate finishDate) {
        this.name = name;
        this.fee = fee;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public abstract double calculate();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
