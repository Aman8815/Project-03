package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.VendorDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelInt;
import in.co.rays.project_3.model.LoanModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.VendorModelInt;
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

@WebServlet(urlPatterns = { "/ctl/VendorCtl" })
public class VendorCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(VendorCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("vendorName"))) {
			request.setAttribute("vendorName", PropertyReader.getValue("error.require", "vendorName"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "mobileNo"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "address"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("serviceType"))) {
			request.setAttribute("serviceType", PropertyReader.getValue("error.require", "serviceType"));
			pass = false;
		} 
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		VendorDTO dto = new VendorDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setVendorName(DataUtility.getString(request.getParameter("vendorName")));
		dto.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		dto.setAddress(DataUtility.getString(request.getParameter("address")));
		dto.setServiceType(DataUtility.getString(request.getParameter("serviceType")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		VendorModelInt model = ModelFactory.getInstance().getVendorModel();
		if (id > 0 || op != null) {
			VendorDTO dto;
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

		VendorModelInt model = ModelFactory.getInstance().getVendorModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			VendorDTO dto = (VendorDTO) populateDTO(request);

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
				ServletUtility.setErrorMessage("Vendor Name Exiest", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.VENDOR_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.VENDOR_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.VENDOR_VIEW;
	}

}
