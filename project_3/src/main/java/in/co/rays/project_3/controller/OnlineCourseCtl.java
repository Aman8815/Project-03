package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.OnlineCourseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.OnlineCourseModelInt;
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

@WebServlet(urlPatterns = { "/ctl/OnlineCourseCtl" })
public class OnlineCourseCtl extends BaseCtl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(OnlineCourseCtl.class);

	protected boolean validate(HttpServletRequest request) {
		log.debug("course ctl validate start");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("course_title"))) {
			request.setAttribute("course_title", PropertyReader.getValue("error.require", "course_title"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("module_name"))) {
			request.setAttribute("module_name", PropertyReader.getValue("error.require", "module_name"));
			pass = false;
		} /*
			 * else if (!DataValidator.isName(request.getParameter("description"))) {
			 * request.setAttribute("description", PropertyReader.getValue("error.name",
			 * "Description")); pass = false; }
			 */
		if (DataValidator.isNull(request.getParameter("duration"))) {
			request.setAttribute("duration", PropertyReader.getValue("error.require", "Duration"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("instructor_name"))) {
			request.setAttribute("instructor_name",PropertyReader.getValue("error.require","instructor_name"));
			pass = false;
		}
		log.debug("course ctl validate end");
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("course ctl populate bean start");
		OnlineCourseDTO dto = new OnlineCourseDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setCourse_title(DataUtility.getString(request.getParameter("course_title")));
		System.out.println(dto.getCourse_title());
		dto.setInstructor_name(DataUtility.getString(request.getParameter("instructor_name")));
		dto.setDuration(DataUtility.getString(request.getParameter("duration")));
		dto.setModule_name(DataUtility.getString(request.getParameter("module_name")));
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
		OnlineCourseModelInt model = ModelFactory.getInstance().getOnlineCourseModel();
		if (id > 0 || op != null) {
			OnlineCourseDTO dto;
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
		OnlineCourseModelInt model = ModelFactory.getInstance().getOnlineCourseModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			OnlineCourseDTO dto = (OnlineCourseDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);
					dto.setId(id);
					ServletUtility.setSuccessMessage("Data Successfully Update", request);
					ServletUtility.setDto(dto, request);
				} else {

					try {
						System.out.println("Online course ki add method");
						Long pk = model.add(dto);
						System.out.println(pk);
						ServletUtility.setSuccessMessage("Data Successfully saved", request);
						ServletUtility.setDto(dto, request);
						ServletUtility.forward(getView(), request, response);
						return;
					} catch (ApplicationException e) {
						log.error(e);
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("course  already exists", request);
					}
				}

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Course TITLE already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			OnlineCourseDTO dto = (OnlineCourseDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.ONLINE_COURSE_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ONLINE_COURSE_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ONLINE_COURSE_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);

		log.debug("course ctl do post end");

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ONLINE_COURSE_VIEW;
	}

}
