package com.ingetis.ikhairy.entities;

import java.util.ArrayList;
import java.util.List;

public class Employe {
    private int employeID;
    private String lastName;
    private String firstName;
    private int count;
    
    List<Employe> employes;

    public Employe(int employeID, String lastName, String firstName) {
        super();
        this.employeID = employeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.employes = new ArrayList<>();
    }

    public Employe(int employeID) {
        super();
        this.employeID = employeID;
        this.employes = new ArrayList<>();
    }
    
    public Employe() {
        super();
        this.employes = new ArrayList<>();
    }

    public int getEmployeID() {
        return employeID;
    }

    public void setEmployeID(int employeID) {
        this.employeID = employeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
