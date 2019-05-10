package com.ingetis.ikhairy.test;

import org.junit.Assert;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployesDeleteStep {
    
    private EmployeDAOImpl dao;
    private int id;
    
    @When("delete employe by id {int}")
    public void delete_employe_by_id(Integer int1) {
        id = int1;
        dao = EmployeDAOStep.getDao();
        Employe employe = new Employe(int1);
        dao.delete(employe);
    }

    @Then("employe with specifyed id should be deleted")
    public void employe_with_specifyed_id_should_be_deleted() {
        Employe employe = new Employe(id);
        dao.chercher(employe);
        if(!employe.getFirstName().equals("DOES NOT EXIST") || !employe.getLastName().equals("DOES NOT EXIST")) {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }
}
