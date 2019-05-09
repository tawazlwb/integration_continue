package com.ingetis.ikhairy.test;

import org.junit.Assert;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeByIDStep {
    
    private EmployeDAOImpl dao;
    private Employe employe;
    
    @When("get employe with id {int}")
    public void get_employe_with_id(Integer int1) {
        dao = EmployeDAOStep.getDao();
        employe = new Employe(int1);
        dao.chercher(employe);
    }

    @Then("employe should be only one or null")
    public void employe_should_be_only_one_or_null() {
        boolean isOneOrNull = false;
        if((!employe.getFirstName().equals("") || 
                !employe.getLastName().equals("")) ||
                employe.getFirstName().equals("DOES NOT EXIST") || 
                employe.getLastName().equals("DOES NOT EXIST")) {
            isOneOrNull = true;
        }
        Assert.assertTrue(isOneOrNull);
    }
}
