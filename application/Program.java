package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the contract data:");
        System.out.print("Number: ");
        int number = in.nextInt();in.nextLine();
        System.out.print("Date: ");
        LocalDate date = LocalDate.parse(in.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Contract Value: ");
        double totalValue = in.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter the number of installments: ");
        int installment = in.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installment); // installment == months

        System.out.println("Installment: ");
        for (Installment inst : contract.getInstallments()){
            System.out.println(inst);
        }

        in.close();
    }
}
