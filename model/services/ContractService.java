package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService service;

    public ContractService(OnlinePaymentService service) {
        this.service = service;
    }

    public void processContract(Contract contract, Integer months){
        double grossValue = contract.getTotalValue() / months;  // valor bruto
        for (int i = 1; i <= months; i++) {
            double interest = service.interest(grossValue, i); // juros do valor bruto
            double paymentFee = service.paymentFee(interest + grossValue); // taxa de pagamento em cima do valor bruto mais os juros
            double netValue = grossValue + interest + paymentFee; // valor liquido

            contract.addInstallment(new Installment(contract.getDate().plusMonths(i), netValue));
        }
    }
}