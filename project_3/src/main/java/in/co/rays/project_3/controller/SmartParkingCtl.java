package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.SmartParkingDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelInt;
import in.co.rays.project_3.model.LoanModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.SmartParkingModelInt;
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

@WebServlet(urlPatterns = { "/ctl/SmartParkingCtl" })
public class SmartParkingCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(SmartParkingCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("parkingCode"))) {
			request.setAttribute("parkingCode", PropertyReader.getValue("error.require", "parkingCode"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("vehicleNumber"))) {
			request.setAttribute("vehicleNumber", PropertyReader.getValue("error.require", "vehicleNumber"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("slotNumber"))) {
			request.setAttribute("slotNumber", PropertyReader.getValue("error.require", "slotNumber"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "status"));
			pass = false;
		} 
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		SmartParkingDTO dto = new SmartParkingDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setParkingCode(DataUtility.getString(request.getParameter("parkingCode")));
		dto.setVehicleNumber(DataUtility.getString(request.getParameter("vehicleNumber")));
		dto.setSlotNumber(DataUtility.getString(request.getParameter("slotNumber")));
		dto.setStatus(DataUtility.getString(request.getParameter("status")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		SmartParkingModelInt model = ModelFactory.getInstance().getSmartParkingModel();
		if (id > 0 || op != null) {
			SmartParkingDTO dto;
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

		SmartParkingModelInt model = ModelFactory.getInstance().getSmartParkingModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			SmartParkingDTO dto = (SmartParkingDTO) populateDTO(request);

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
				ServletUtility.setErrorMessage("Parking  Code Exiest", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.SMARTPARKING_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.SMARTPARKING_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SMARTPARKING_VIEW;
	}

}
