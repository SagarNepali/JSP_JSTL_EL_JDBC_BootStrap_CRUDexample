/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.dis.controller;

import com.dumbweb.dis.dao.DoctorDAO;
import com.dumbweb.dis.dao.impl.DoctorDAOimpl;
import com.dumbweb.dis.entity.Doctor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "defaultController", urlPatterns = {"/doctor", "/doctor/*"})
public class DefaultController extends HttpServlet {

    private DoctorDAO doctorDAO = new DoctorDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPage = "/WEB-INF/views/doctor/index.jsp";

        String path = request.getRequestURI().toLowerCase();
        boolean redirect = false;

        if (path.contains("/add")) {

            viewPage = "/WEB-INF/views/doctor/add.jsp";

        } else if (path.contains("/edit")) {

            if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/doctor?error");
                redirect = true;
            } else if (!request.getParameter("id").isEmpty()) {

                int id = Integer.parseInt(request.getParameter("id"));
                Doctor d = doctorDAO.searchById(id);
                if (d == null) {
                    response.sendRedirect(request.getContextPath() + "/doctor?error");
                    redirect = true;
                } else {
                    request.setAttribute("selectedDoc", d);
                }

            }
            viewPage = "/WEB-INF/views/doctor/edit.jsp";

        } else if (path.contains("/delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            doDel(id, request, response);
            viewPage = "/WEB-INF/views/doctor/index.jsp";
            redirect = true;

        } else {

            request.setAttribute("docList", doctorDAO.showAll());
        }

        if (!redirect) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Doctor d = new Doctor();

        d.setFirstName(request.getParameter("firstName"));
        d.setLastName(request.getParameter("lastName"));
        d.setAddress(request.getParameter("address"));
        d.setContact(request.getParameter("contact"));
        d.setSpecialization(request.getParameter("specialization"));
        d.setWorkplace(request.getParameter("workplace"));

        if (request.getParameter("id") != null) {

            int id = Integer.parseInt(request.getParameter("id"));
            d.setId(id);
            doctorDAO.update(d);
        } else {
            doctorDAO.insert(d);
        }

        if (response != null) {
            response.sendRedirect(request.getContextPath() + "/doctor");
        }
    }

    protected void doDel(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Doctor d = doctorDAO.searchById(id);

        if (d != null) {
            doctorDAO.delete(d);
        } else {
            System.out.println("Cannot delete1s");
        }

        response.sendRedirect(request.getContextPath() + "/doctor");
    }

}
