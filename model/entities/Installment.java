package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment { //prestações
    private LocalDate dueDate; // data de vencimento
    private Double amount; // quantia

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return dueDate.format(dtf) + " - " + String.format("%.2f", amount);
    }
}
