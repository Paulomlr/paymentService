package model.services;

public interface OnlinePaymentService {
    Double paymentFee(Double amount); // taxa de pagamento
    Double interest(Double amount, Integer months); // juros
}
