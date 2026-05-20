package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.VoiceAssistantDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelInt;
import in.co.rays.project_3.model.LoanModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.VoiceAssistantModelInt;
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

@WebServlet(urlPatterns = { "/ctl/VoiceAssistantCtl" })
public class VoiceAssistantCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(VoiceAssistantCtl.class);

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("userVoice"))) {
			request.setAttribute("userVoice", PropertyReader.getValue("error.require", "userVoice"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("response"))) {
			request.setAttribute("response", PropertyReader.getValue("error.require", "response"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("language"))) {
			request.setAttribute("language", PropertyReader.getValue("error.require", "language"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("accuracy"))) {
			request.setAttribute("accuracy", PropertyReader.getValue("error.require", "accuracy"));
			pass = false;
		} 
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		VoiceAssistantDTO dto = new VoiceAssistantDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setUserVoice(DataUtility.getString(request.getParameter("userVoice")));
		dto.setResponse(DataUtility.getString(request.getParameter("response")));
		dto.setLanguage(DataUtility.getString(request.getParameter("language")));
		dto.setAccuracy(DataUtility.getInt(request.getParameter("accuracy")));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		VoiceAssistantModelInt model = ModelFactory.getInstance().getVoiceAssistantModel();
		if (id > 0 || op != null) {
			VoiceAssistantDTO dto;
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

		VoiceAssistantModelInt model = ModelFactory.getInstance().getVoiceAssistantModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			VoiceAssistantDTO dto = (VoiceAssistantDTO) populateDTO(request);

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
				ServletUtility.setErrorMessage("User Voice Exiest", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.VOICEASSISTANT_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.VOICEASSISTANT_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.VOICEASSISTANT_VIEW;
	}

}
