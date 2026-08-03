package in.co.rays.project_3.dto;

public class ResultDTO extends BaseDTO {
	
	private String studentId;
	
	private Integer percentage;
	
	private String grade;
	
	private String resultStatus;
	

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+" ";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return studentId;
	}

}
