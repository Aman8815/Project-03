package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.RefundDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RefundModelInt;
import in.co.rays.project_3.model.StaffMemberModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/RefundCtl" })
public class RefundCtl extends BaseCtl{
	private static Logger log = Logger.getLogger(FacultyCtl.class);

	protected boolean validate(HttpServletRequest request) {
		log.debug("StaffMember ctl validate start");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("refundCode"))) {
			request.setAttribute("refundCode", PropertyReader.getValue("error.require", "refundCode"));
			pass = false;
		} 

		if (DataValidator.isNull(request.getParameter("refundAmount"))) {
			request.setAttribute("refundAmount", PropertyReader.getValue("error.require", "refund Amount"));
			pass = false;
		} else if (!DataValidator.isDate(request.getParameter("refundDate"))) {
			request.setAttribute("refundDate", PropertyReader.getValue("error.date", " refund Date"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("refundDate"))) {
			request.setAttribute("refundDate", PropertyReader.getValue("error.require", "refund Date"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("refundStatus"))) {
			request.setAttribute("refundStatus", PropertyReader.getValue("error.require", "refund Status"));
			pass = false;
		}
		log.debug("staffMember ctl validate end");
		return pass;

	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("staffMember ctl populate bean start");
		System.out.println("staffMember bean populate start");
		RefundDTO dto = new RefundDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setRefundCode(DataUtility.getString(request.getParameter("refundCode")));
		dto.setRefundAmount(DataUtility.getString(request.getParameter("refundAmount")));
		dto.setRefundStatus(DataUtility.getString(request.getParameter("refundStatus")));
		dto.setRefundDate(DataUtility.getDate(request.getParameter("refundDate")));
		populateBean(dto, request);
		log.debug("staffMember ctl populate bean end");
		return dto;

	}

	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		log.debug("staffMember ctl do get start");
		System.out.println("============");

		RefundModelInt model = ModelFactory.getInstance().getRefundModel();
		RefundDTO dto = new RefundDTO();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {

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
		log.debug("staffMember ctl do get end");
	}

	/**
	 * Submit logic inside it
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("staffMember do post start");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		RefundModelInt model = ModelFactory.getInstance().getRefundModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			RefundDTO dto = (RefundDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);
					ServletUtility.setSuccessMessage("Data is successfully Update", request);
				} else {

					try {
						model.add(dto);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} catch (ApplicationException e) {
						log.error(e);
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Refund Code already exists", request);
					}

				}
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Refund Code already exists", request);
			}

		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			System.out.println("alteast");
			RefundDTO dto = (RefundDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.REFUND_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.debug(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.REFUND_LIST_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.REFUND_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("Refund  do post end");
	}

	@Override
	protected String getView() {
		return ORSView.REFUND_VIEW;
	}
}
