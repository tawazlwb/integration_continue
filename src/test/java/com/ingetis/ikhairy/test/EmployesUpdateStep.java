package com.ingetis.ikhairy.test;

import java.util.List;

import org.junit.Assert;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployesUpdateStep {
    
    private EmployeDAOImpl dao;
    private Employe employe;
    private List<String> e;
    
    
    @When("update employe by id")
    public void update_employe_by_id(List<String> emp) {
        e = emp;
        dao = EmployeDAOStep.getDao();
        employe = new Employe(Integer.parseInt(emp.get(0)));
        employe.setFirstName(emp.get(1));
        employe.setLastName(emp.get(2));
        dao.update(employe);        
    }

    @Then("employe first name and last name should be inversed")
    public void employe_first_name_and_last_name_should_be_inversed() {
        Assert.assertTrue(employe.getEmployeID() == Integer.parseInt(e.get(0)));
        Assert.assertTrue(employe.getFirstName().equals(e.get(1)));
        Assert.assertTrue(employe.getLastName().equals(e.get(2)));
    }
}
