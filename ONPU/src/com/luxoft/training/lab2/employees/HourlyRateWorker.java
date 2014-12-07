package com.luxoft.training.lab2.employees;

public class HourlyRateWorker extends Worker implements HourlyRate {

    private double rate;
    private int hours;

    public HourlyRateWorker() {
        super("Hourly rate");
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double calcPayment() {
        return rate * hours;
    }

    @Override
    protected void printPaymentInfo() {
        System.out.println("Working hours: " + hours);
        System.out.println("Hourly rate: " + rate);
    }

}
