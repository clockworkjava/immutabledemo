package pl.clockworkjava.immutable;

import java.time.LocalDate;

public class ImmutableApp {

    public static void main(String[] args) {

        Invoice invoice = new Invoice(100,"Clockwork Java");

        LocalDate invoiceDate = invoice.getInvoiceDate();

        System.out.println(invoiceDate);

        invoiceDate.minusWeeks(3);

        System.out.println(invoice.getInvoiceDate());

        Invoice anotherInvoice = invoice.changeAmountTo(400);

        System.out.println(invoice==anotherInvoice);
    }
}
