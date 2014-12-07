package com.luxoft.training.lab2.employees;

public class BaseSalaryCommWorker extends Worker implements MonthlySalary, Commission {

    private double salary;
    private double sales;
    private double commission;

    public BaseSalaryCommWorker(String paymentType) {
        super("Base salary + commission");
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
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
        return salary + sales * commission;
    }

    @Override
    protected void printPaymentInfo() {
        System.out.println("Base salary: " + salary);
        System.out.println("Sales amount: " + sales);
        System.out.println("Commission: " + commission);
    }

}
