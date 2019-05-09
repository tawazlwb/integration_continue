package com.ingetis.ikhairy.dao;

import java.sql.ResultSet;

import com.ingetis.ikhairy.db.ParametreBD;
import com.ingetis.ikhairy.entities.Employe;

public class EmployeDAOImpl implements IEmploye {
    // Read
    public void chercher(Employe emp) {
        String requete = "select * from employees where EmployeeID = " + emp.getEmployeID();

        try {
            ResultSet infos = ParametreBD.executerSelect(requete);
            infos.next();
            emp.setFirstName(infos.getString(3));
            emp.setLastName(infos.getString(2));
        } catch (Exception e) {
            emp.setFirstName("DOES NOT EXIST");
            emp.setLastName("DOES NOT EXIST");
        }
    }
    
    // Update
    public void update(Employe emp) {
        String requete = "UPDATE employees SET LastName='"+ emp.getLastName() + "', FirstName='"+ emp.getFirstName() + "' WHERE EmployeeID = " + emp.getEmployeID();
        try {
             ParametreBD.executerUpdate(requete);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Insert
    public void insert(Employe emp) {
        String requete = "INSERT INTO employees (LastName, FirstName) VALUES ('"+ emp.getLastName() +"', '"+ emp.getFirstName()+"')";
        try {
             int id = ParametreBD.executerInsert(requete);
             emp.setEmployeID(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Delete
    public void delete(Employe emp) {
        String requete = "DELETE FROM employees WHERE EmployeeID = " + emp.getEmployeID();
        try {
             ParametreBD.executerUpdate(requete);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Nombre d'employes
    public void count(Employe emp) {
        String requete = "SELECT COUNT(*) FROM employees";
        
        try {
            ResultSet infos = ParametreBD.executerSelect(requete);
            infos.next();
            emp.setCount(infos.getInt(1));
        } catch (Exception e) {
            emp.setCount(0);
        }
    }
    
    // List employes
    public void getEmployes(int page, int nombre, Employe emp) {
        String requete = "SELECT * FROM employees LIMIT " + page + "," + nombre + ";";
        
        try {
            ResultSet infos = ParametreBD.executerSelect(requete);
            while(infos.next()) {
                //System.out.println(infos.getInt(1) + " " + infos.getString(2));
                emp.getEmployes().add(new Employe(infos.getInt(1), infos.getString(2), infos.getString(3)));
            }
            //this.setEmployes(employes);
        } catch (Exception e) {
            emp.setCount(0);
        }
    }
}
