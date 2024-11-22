package com.example.assignment;

public class Person {
    private String name;
    private String fatherName;
    private String cnic;
    private String dob;
    private String gender;
    private String city;

    public String getName() {
        return name;}
    public String getFatherName() {
        return fatherName;}
    public String getCnic() {
        return cnic;}
    public String getDob() {
        return dob;}
    public String getGender() {
        return gender;}
    public String getCity() {
        return city;}
    Person(String name, String fatherName, String cnic, String dob, String gender, String city) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.dob = dob;
        this.gender = gender;
        this.city = city;}
}
