package pl.clockworkjava.immutable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final public class Invoice {

    private int amount;
    private String companyName;
    private LocalDate invoiceDate;
    private List<String> items;

    public Invoice(int amount, String companyName, List<String> items) {
        this.amount = amount;
        this.companyName = companyName;
        this.invoiceDate = LocalDate.now();
        this.items  = new ArrayList<>(items.size());
        Collections.copy(this.items ,items);
    }

    private Invoice(int amount, String companyName, List<String> items, LocalDate invoiceDate) {
        this.amount = amount;
        this.companyName = companyName;
        this.invoiceDate = invoiceDate;
        this.items  = new ArrayList<>(items.size());
        Collections.copy(this.items ,items);
    }

    public int getAmount() {
        return amount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getInvoiceDate() {
        // no need for copy, LocalDate is immutable itself
        return this.invoiceDate;
    }

    public Invoice changeAmountTo(int newAmount) {
        return new Invoice(newAmount, this.companyName, this.items, this.invoiceDate);
    }

    public List<String> getItems() {
        List<String> result = new ArrayList<>(this.items.size());
        Collections.copy(result,this.items);
        return result;
    }
}
