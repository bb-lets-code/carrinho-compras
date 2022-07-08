package br.shop.bb.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Payment{
    private LocalDate paid;
    private BigDecimal total;

    public Payment(){
        this.total = BigDecimal.ZERO;
    }

    public LocalDate getPaid() {
        return paid;
    }

    public void setPaid(LocalDate paid) {
        this.paid = paid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return  "paid=" + paid +
                ", total=" + total;
    }
}
