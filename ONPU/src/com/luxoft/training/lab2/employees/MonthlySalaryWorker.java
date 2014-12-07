package com.luxoft.training.lab2.employees;


public class MonthlySalaryWorker extends Worker implements MonthlySalary {

    private double salary;

    public MonthlySalaryWorker() {
        super("Monthly salary");
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
    public double calcPayment() {
        return salary;
    }

    @Override
    protected void printPaymentInfo() {
        System.out.println("Salary: " + salary);
    }
}
