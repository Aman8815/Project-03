package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.LoanDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelInt;
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

@WebServlet(urlPatterns = { "/ctl/LoanCtl" })
public class LoanCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoanCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("lenderName"))) {
			request.setAttribute("lenderName", PropertyReader.getValue("error.require", "lenderName"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("lenderName"))) {
			request.setAttribute("lenderName",PropertyReader.getValue("error.require", "lenderName"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("loanAmount"))) {
			request.setAttribute("loanAmount", PropertyReader.getValue("error.require", "loanAmount"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("interestRate"))) {
			request.setAttribute("interestRate", PropertyReader.getValue("error.require", "interestRate"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("maturityDate"))) {
			request.setAttribute("maturityDate", PropertyReader.getValue("error.require", "maturityDate"));
			pass = false;
		} 
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		LoanDTO dto = new LoanDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setLenderName(DataUtility.getString(request.getParameter("lenderName")));
		dto.setLoanAmount(DataUtility.getLong(request.getParameter("loanAmount")));
		dto.setInterestRate(DataUtility.getLong(request.getParameter("interestRate")));
		dto.setMaturityDate(DataUtility.getDate(request.getParameter("maturityDate")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		LoanModelInt model = ModelFactory.getInstance().getLoanModel();
		if (id > 0 || op != null) {
			LoanDTO dto;
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

		LoanModelInt model = ModelFactory.getInstance().getLoanModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			LoanDTO dto = (LoanDTO) populateDTO(request);

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
				ServletUtility.setErrorMessage("Lender Name Exiest", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.LOAN_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.LOAN_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.LOAN_VIEW;
	}

}
