package com.luxoft.training.lab2.employees;

import com.luxoft.training.utils.Date;


public abstract class Worker {

    private String firstName;
    private String lastName;
    private String position;
    private final String paymentType;
    private Date birthday;

    protected Worker(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public abstract double calcPayment();

    public void printInfo() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Position: " + position);
        System.out.println("Payment type: " + paymentType);
        printPaymentInfo();
        System.out.println("Payment: " + calcPayment());
        System.out.println();
    }

    protected abstract void printPaymentInfo();

}
