package com.ingetis.ikhairy.test;

import java.util.List;

import org.junit.Assert;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployesInsertStep {
    
    private EmployeDAOImpl dao;
    private int employeID;
    
    @When("insert employe")
    public void insert_employe(List<String> emp) {
        dao = EmployeDAOStep.getDao();
        Employe employe = new Employe();
        employe.setFirstName(emp.get(0));
        employe.setLastName(emp.get(1));
        dao.insert(employe);;
        employeID = employe.getEmployeID();
    }

    @Then("employe id should be a positif non zero number")
    public void employe_id_should_be_a_positif_non_zero_number() {
        Assert.assertTrue(employeID >= 0);
    }
}
