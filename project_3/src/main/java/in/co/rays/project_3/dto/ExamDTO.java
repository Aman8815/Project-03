package in.co.rays.project_3.dto;

public class ExamDTO extends BaseDTO {
	
	private String examName;
	private String examCenter;
	private Integer totalMarks;
	private Integer passingMarks;
	

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamCenter() {
		return examCenter;
	}

	public void setExamCenter(String examCenter) {
		this.examCenter = examCenter;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Integer getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(Integer passingMarks) {
		this.passingMarks = passingMarks;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return examName;
	}

}
