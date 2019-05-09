package com.ingetis.ikhairy.test;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;

public class EmployeDAOStep {
    private static EmployeDAOImpl dao;
    
    private static void init() {
        dao = new EmployeDAOImpl();
    }

    public static EmployeDAOImpl getDao() {
        if(dao == null)
            init();
        return dao;
    }
}
