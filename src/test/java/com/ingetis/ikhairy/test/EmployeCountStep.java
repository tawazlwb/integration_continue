package com.ingetis.ikhairy.test;

import org.junit.Assert;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeCountStep {
    
    private EmployeDAOImpl dao;
    private boolean isCountPositif;
    
    @Given("my employe dao class exists")
    public void my_employe_dao_class_exists() {
        dao = EmployeDAOStep.getDao();
    }

    @When("get employe count")
    public void get_employe_count() {
        Employe emp = new Employe();
        dao.count(emp);
        isCountPositif = emp.getCount() >= 0 ? true : false;
    }

    @Then("employe count should be positif number")
    public void employe_count_should_be_positif_number() {
        Assert.assertTrue(isCountPositif);
    }
}
