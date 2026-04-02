package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.BudgetDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.BudgetModelInt;
import in.co.rays.project_3.model.CarRentalModelInt;
import in.co.rays.project_3.model.MeetingRoomModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.OnlineCourseModelInt;
import in.co.rays.project_3.model.ScheduleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

/**
 * course functionality ctl.to perform add,delete ,update operation
 * 
 * @author Aman Yashona
 *
 */

@WebServlet(urlPatterns = { "/ctl/BudgetCtl" })
public class BudgetCtl extends BaseCtl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(BudgetCtl.class);

	protected boolean validate(HttpServletRequest request) {
		log.debug("course ctl validate start");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("allocatedAmount"))) {
			request.setAttribute("allocatedAmount", PropertyReader.getValue("error.require", "allocated Amount"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("spentAmount"))) {
			request.setAttribute("spentAmount", PropertyReader.getValue("error.require", "spentAmount"));
			pass = false;
		} /*
			 * else if (!DataValidator.isName(request.getParameter("description"))) {
			 * request.setAttribute("description", PropertyReader.getValue("error.name",
			 * "Description")); pass = false; }
			 */
		if (DataValidator.isNull(request.getParameter("department"))) {
			request.setAttribute("department", PropertyReader.getValue("error.require", "department"));
			pass = false;
		}
		
		log.debug("course ctl validate end");
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("course ctl populate bean start");
		BudgetDTO dto = new BudgetDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setAllocatedAmount(DataUtility.getLong(request.getParameter("allocatedAmount")));
		dto.setSpentAmount(DataUtility.getLong(request.getParameter("spentAmount")));
		dto.setDepartment(DataUtility.getString(request.getParameter("department")));
		populateBean(dto, request);
		log.debug("course ctl populate bean end");

		return dto;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("IN do get online course");
		log.debug("course ctl do get start");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		BudgetModelInt model = ModelFactory.getInstance().getBudgetModel();
		if (id > 0 || op != null) {
			BudgetDTO dto;
			System.out.println("asdfghjklmnbvcx"+id);
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("course ctl do get end");
	}

	/**
	 * Submit logic inside it
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("course ctl do post start");
		
		System.out.println("in do post11111");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		BudgetModelInt model = ModelFactory.getInstance().getBudgetModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			BudgetDTO dto = (BudgetDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);
					dto.setId(id);
					ServletUtility.setSuccessMessage("Data Successfully Update", request);
					ServletUtility.setDto(dto, request);
				} else {

					try {
						
						 model.add(dto);
						
						ServletUtility.setSuccessMessage("Data Successfully saved", request);
						ServletUtility.setDto(dto, request);
						System.out.println("asdfghjhgfds"+dto.getId());
						ServletUtility.forward(getView(), request, response);
						return;
					} catch (ApplicationException e) {
						e.printStackTrace();
						log.error(e);
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Department  already exists", request);
					}
				}

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("department already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			BudgetDTO dto = (BudgetDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.BUDGET_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.BUDGET_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.BUDGET_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);

		log.debug("course ctl do post end");

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.BUDGET_VIEW;
	}

}
