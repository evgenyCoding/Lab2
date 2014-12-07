package com.luxoft.training.lab2.employees;


public class CommissionWorker extends Worker implements Commission {

    private double sales;
    private double commission;

    public CommissionWorker() {
        super("Commission");
    }

    @Override
    public double getSales() {
        return sales;
    }

    @Override
    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public double getCommission() {
        return commission;
    }

    @Override
    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public double calcPayment() {
        return sales * commission;
    }

    @Override
    protected void printPaymentInfo() {
        System.out.println("Sales amount: " + sales);
        System.out.println("Commission: " + commission);
    }

}
