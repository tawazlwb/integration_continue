package com.ingetis.ikhairy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ingetis.ikhairy.dao.EmployeDAOImpl;
import com.ingetis.ikhairy.entities.Employe;

/**
 * Servlet implementation class Choix
 */
@WebServlet("/gestion")
public class Gestion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int size;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion() {
        super();
        this.size = 10;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmployeDAOImpl dao = new EmployeDAOImpl();

        // chercher
        if (request.getParameterMap().containsKey("submit")
                && request.getParameter("submit").toString().equals("chercher")) {
            if (request.getParameterMap().containsKey("employeID")
                    && !request.getParameter("employeID").toString().equals("")) {
                // appel db
                Employe employe = new Employe(Integer.parseInt(request.getParameter("employeID")));
                dao.chercher(employe);
                request.setAttribute("employe", employe);
            }
        }
        // modifier
        else if (request.getParameterMap().containsKey("submit")
                && request.getParameter("submit").toString().equals("modifier")) {
            if (request.getParameterMap().containsKey("employeID")
                    && request.getParameterMap().containsKey("firstName")
                    && request.getParameterMap().containsKey("lastName")
                    && !request.getParameter("employeID").toString().equals("")
                    && !request.getParameter("firstName").toString().equals("")
                    && !request.getParameter("lastName").toString().equals("")) {
                // appel db
                Employe employe = new Employe(Integer.parseInt(request.getParameter("employeID")));
                employe.setFirstName(request.getParameter("firstName").toString());
                employe.setLastName(request.getParameter("lastName").toString());
                dao.update(employe);
                request.setAttribute("employe", employe);
            }
        }
        // ajouter
        else if (request.getParameterMap().containsKey("submit")
                && request.getParameter("submit").toString().equals("ajouter")) {
            if (request.getParameterMap().containsKey("firstName")
                    && request.getParameterMap().containsKey("lastName")
                    && !request.getParameter("firstName").toString().equals("")
                    && !request.getParameter("lastName").toString().equals("")) {
                // appel db
                Employe employe = new Employe();
                employe.setFirstName(request.getParameter("firstName").toString());
                employe.setLastName(request.getParameter("lastName").toString());
                dao.insert(employe);
                request.setAttribute("employe", employe);
            }
        }
        // supprimer
        else if (request.getParameterMap().containsKey("submit")
                && request.getParameter("submit").toString().equals("supprimer")) {
            if (request.getParameterMap().containsKey("employeID")
                    && !request.getParameter("employeID").toString().equals("")) {
                // appel db
                Employe employe = new Employe(Integer.parseInt(request.getParameter("employeID")));
                dao.delete(employe);
                request.setAttribute("employe", new Employe());
            }
        }
        
        // pagination
        Employe employe = new Employe();
        dao.count(employe);
        request.setAttribute("count", employe.getCount());
        
        // Current page
        int page = 0;
        if(request.getParameterMap().containsKey("currentPage")) {
            page = Integer.parseInt(request.getParameter("currentPage"));
        }
        request.setAttribute("currentPage", page);
        
        // list employes
        dao.getEmployes((page) * this.size, this.size, employe);
        request.setAttribute("employes", employe.getEmployes());
        
        RequestDispatcher view = request.getRequestDispatcher("gestion.jsp");
        view.forward(request, response);
    }
}
