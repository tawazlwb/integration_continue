package com.ingetis.ikhairy.test;

import org.junit.Assert;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployesListStep {
    
    private EmployeDAOImpl dao;
    private int employesCount;
    
    @When("get all employes")
    public void get_all_employes() {
        dao = EmployeDAOStep.getDao();
        Employe employe = new Employe();
        dao.getEmployes(0, 10, employe);
        employesCount = employe.getEmployes().size();
    }

    @Then("employes should be list of size zero or plus")
    public void employes_should_be_list_of_size_zero_or_plus() {
        Assert.assertTrue(employesCount >= 0);
    }
}
