package com.wipro.school.servlets;

import java.io.IOException;

import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.wipro.school.bean.SchoolBean;
import com.wipro.school.service.Administrator;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String operation = request.getParameter("operation");
        Administrator admin = new Administrator();
        if ("newRecord".equals(operation)) {
        	SchoolBean bean = new SchoolBean();
            bean.setStudentName(request.getParameter("studentName"));
            bean.setClassName(request.getParameter("className"));
            bean.setSection(request.getParameter("section"));
            bean.setAge(Integer.parseInt(request.getParameter("age")));
            bean.setRemarks(request.getParameter("remarks"));
            try {
                java.util.Date date =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("admissionDate"));
                bean.setAdmissionDate(date);
                } catch (Exception e) {
            	response.sendRedirect("error.html");
                return;
            }
            String result = admin.addRecord(bean);
            if (result.equals("FAIL") || result.equals("INVALID INPUT"))
                response.sendRedirect("error.html");
            else
                response.sendRedirect("success.html");
}
               else if ("viewRecord".equals(operation)) {
               try {
                String name = request.getParameter("studentName");
                java.util.Date date =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("admissionDate"));
                SchoolBean bean = admin.viewRecord(name, date);
                if (bean == null) {
                request.setAttribute("message","No matching records exists! Please try again!");
                } else {
                request.setAttribute("schoolBean", bean);
}
                request.getRequestDispatcher("displayStudent.jsp")
                        .forward(request, response);
}
               catch (Exception e) {
            	response.sendRedirect("error.html");
               }
        }
    }
}
