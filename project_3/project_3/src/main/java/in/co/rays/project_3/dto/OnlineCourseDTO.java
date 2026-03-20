package in.co.rays.project_3.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

public class OnlineCourseDTO extends BaseDTO {
	
	private String course_title;

    private String module_name;

   private String duration;

   
   private String instructor_name;

	public String getCourse_title() {
	return course_title;
}

public void setCourse_title(String course_title) {
	this.course_title = course_title;
}

public String getModule_name() {
	return module_name;
}

public void setModule_name(String module_name) {
	this.module_name = module_name;
}

public String getDuration() {
	return duration;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public String getInstructor_name() {
	return instructor_name;
}

public void setInstructor_name(String instructor_name) {
	this.instructor_name = instructor_name;
}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return course_title;
	}

}
