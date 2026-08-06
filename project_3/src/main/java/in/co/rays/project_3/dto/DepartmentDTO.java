package in.co.rays.project_3.dto;

public class DepartmentDTO  extends BaseDTO{
	
	private String departmentName;
	
	private String hodName;
	
	private Integer totalFaculty;
	
	private String location;
	

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public Integer getTotalFaculty() {
		return totalFaculty;
	}

	public void setTotalFaculty(Integer totalFaculty) {
		this.totalFaculty = totalFaculty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return departmentName;
	}

}
