package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.FeeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelInt;
import in.co.rays.project_3.model.FeeModelInt;
import in.co.rays.project_3.model.LoanModelInt;
import in.co.rays.project_3.model.ModelFactory;
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

@WebServlet(urlPatterns = { "/ctl/FeeCtl" })
public class FeeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(FeeCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("studentId"))) {
			request.setAttribute("studentId", PropertyReader.getValue("error.require", "studentId"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("amount"))) {
			request.setAttribute("amount", PropertyReader.getValue("error.require", "amount"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("paymentDate"))) {
			request.setAttribute("paymentDate", PropertyReader.getValue("error.require", "paymentDate"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("paymentStatus"))) {
			request.setAttribute("paymentStatus", PropertyReader.getValue("error.require", "paymentStatus"));
			pass = false;
		} 
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		FeeDTO dto = new FeeDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setStudentId(DataUtility.getString(request.getParameter("studentId")));
		dto.setAmount(DataUtility.getInt(request.getParameter("amount")));
		dto.setPaymentDate(DataUtility.getDate(request.getParameter("paymentDate")));
		dto.setPaymentStatus(DataUtility.getString(request.getParameter("paymentStatus")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		FeeModelInt model = ModelFactory.getInstance().getFeeModel();
		if (id > 0 || op != null) {
			FeeDTO dto;
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

		FeeModelInt model = ModelFactory.getInstance().getFeeModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			FeeDTO dto = (FeeDTO) populateDTO(request);

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
				ServletUtility.setErrorMessage("student Id Exiest", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.LOAN_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.FEE_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.FEE_VIEW;
	}

}
