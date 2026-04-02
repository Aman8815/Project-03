package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.CarRentalDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
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

@WebServlet(urlPatterns = { "/ctl/CarRentalCtl" })
public class CarRentalCtl extends BaseCtl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CarRentalCtl.class);

	protected boolean validate(HttpServletRequest request) {
		log.debug("course ctl validate start");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("customerName"))) {
			request.setAttribute("customerName", PropertyReader.getValue("error.require", "customer Name"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("carModel"))) {
			request.setAttribute("carModel", PropertyReader.getValue("error.require", "car Model"));
			pass = false;
		} /*
			 * else if (!DataValidator.isName(request.getParameter("description"))) {
			 * request.setAttribute("description", PropertyReader.getValue("error.name",
			 * "Description")); pass = false; }
			 */
		if (DataValidator.isNull(request.getParameter("rentalDate"))) {
			request.setAttribute("rentalDate", PropertyReader.getValue("error.require", "rental Date"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("returnDate"))) {
			request.setAttribute("returnDate",PropertyReader.getValue("error.require","customer Code"));
			pass = false;
		}
		log.debug("course ctl validate end");
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("course ctl populate bean start");
		CarRentalDTO dto = new CarRentalDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		dto.setCarModel(DataUtility.getString(request.getParameter("carModel")));
		dto.setRentalDate(DataUtility.getDate(request.getParameter("rentalDate")));
		dto.setReturnDate(DataUtility.getString(request.getParameter("returnDate")));
		System.out.println(dto.getReturnDate()+"return date");
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
		CarRentalModelInt model = ModelFactory.getInstance().getCarRentalModel();
		if (id > 0 || op != null) {
			CarRentalDTO dto;
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
		CarRentalModelInt model = ModelFactory.getInstance().getCarRentalModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			CarRentalDTO dto = (CarRentalDTO) populateDTO(request);
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
						ServletUtility.setErrorMessage("Customer Code  already exists", request);
					}
				}

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Customer Code already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			CarRentalDTO dto = (CarRentalDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.CAR_RENTAL_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.CAR_RENTAL_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.CAR_RENTAL_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);

		log.debug("course ctl do post end");

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CAR_RENTAL_VIEW;
	}

}
