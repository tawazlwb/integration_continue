package com.ingetis.ikhairy.dao;

import com.ingetis.ikhairy.entities.Employe;

public interface IEmploye {
    public void chercher(Employe emp);
    public void update(Employe emp);
    public void insert(Employe emp);
    public void delete(Employe emp);
    public void count(Employe emp);
    public void getEmployes(int page, int nombre, Employe emp);
}
