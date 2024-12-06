package org.example;

public class BookingService {
    private  PaymentService paymentService;

    public BookingService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public int payment(int product1, int product2){
        return paymentService.processPayment(product1,product2);
    }
}
