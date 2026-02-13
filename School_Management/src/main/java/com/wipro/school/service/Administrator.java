package com.wipro.school.service;

import com.wipro.school.bean.SchoolBean;

import com.wipro.school.dao.SchoolDAO;
import com.wipro.school.util.InvalidInputException;

public class Administrator {
	SchoolDAO dao = new SchoolDAO();
    public String addRecord(SchoolBean bean) {
    	try {
        	if (bean == null || bean.getStudentName() == null || bean.getAdmissionDate() == null)throw new InvalidInputException();
            if (bean.getStudentName().length() < 2)
                return "INVALID STUDENT NAME";
            if (recordExists(bean.getStudentName(), bean.getAdmissionDate()))
                return "ALREADY EXISTS";
            String id = dao.generateRecordID(bean.getStudentName(), bean.getAdmissionDate());
            bean.setRecordId(id);
            return dao.createRecord(bean);
            }
        catch (InvalidInputException e) {
        	return "INVALID INPUT";
            }
    }
    public SchoolBean viewRecord(String studentName, java.util.Date date) {
    	return dao.fetchRecord(studentName, date);
        }
    public boolean recordExists(String studentName, java.util.Date admissionDate) {
            return dao.fetchRecord(studentName, admissionDate) != null;
        }
}
