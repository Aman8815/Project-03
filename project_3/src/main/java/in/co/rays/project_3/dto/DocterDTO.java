package in.co.rays.project_3.dto;

public class DocterDTO  extends BaseDTO{
	
	private String doctorName;
	
	private String specialization;
	
	private Integer experience;
	
	private String contectNo;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getContectNo() {
		return contectNo;
	}

	public void setContectNo(String contectNo) {
		this.contectNo = contectNo;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return doctorName;
	}

}
