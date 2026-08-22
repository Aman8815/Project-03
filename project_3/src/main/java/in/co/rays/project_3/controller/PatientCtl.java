package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.PatientDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelInt;
import in.co.rays.project_3.model.LoanModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.PatientModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

/**
 * college functionality ctl. To perform add,delete ,update operation
 * 
 * @author Aman Yashona
 * 
 */

@WebServlet(urlPatterns = { "/ctl/PatientCtl" })
public class PatientCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(PatientCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("doctorName"))) {
			request.setAttribute("doctorName", PropertyReader.getValue("error.require", "doctorName"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("disease"))) {
			request.setAttribute("disease", PropertyReader.getValue("error.require", "disease"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("patientName"))) {
			request.setAttribute("patientName", PropertyReader.getValue("error.require", "patientName"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("admissionDate"))) {
			request.setAttribute("admissionDate", PropertyReader.getValue("error.require", "admissionDate"));
			pass = false;
		} 
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		PatientDTO dto = new PatientDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setDoctorName(DataUtility.getString(request.getParameter("doctorName")));
		dto.setDisease(DataUtility.getString(request.getParameter("disease")));
		dto.setPatientName(DataUtility.getString(request.getParameter("patientName")));
		dto.setAdmissionDate(DataUtility.getDate(request.getParameter("admissionDate")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		PatientModelInt model = ModelFactory.getInstance().getPatientModel();
		if (id > 0 || op != null) {
			PatientDTO dto;
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));

		PatientModelInt model = ModelFactory.getInstance().getPatientModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			PatientDTO dto = (PatientDTO) populateDTO(request);

			try {
				if (id > 0) {
					dto.setId(id);
					model.update(dto);
					ServletUtility.setDto(dto, request);

					ServletUtility.setSuccessMessage("Record Successfully Updated", request);

				} else {
					System.out.println("college add" + dto + "id...." + id);
					// long pk
					model.add(dto);
					ServletUtility.setSuccessMessage("Record Successfully Saved", request);
					ServletUtility.forward(getView(), request, response);
					return;
				}
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Docter Name Exiest", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PATIENT_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.PATIENT_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PATIENT_VIEW;
	}

}
