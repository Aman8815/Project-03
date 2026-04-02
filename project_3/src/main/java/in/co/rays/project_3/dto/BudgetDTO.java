package in.co.rays.project_3.dto;

public class BudgetDTO extends BaseDTO {
  
	
	
	private Long allocatedAmount;
	private Long spentAmount;
	private String department;
	
	
	public Long getAllocatedAmount() {
		return allocatedAmount;
	}
	
	public void setAllocatedAmount(Long allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}
	
	public Long getSpentAmount() {
		return spentAmount;
	}
	
	public void setSpentAmount(Long spentAmount) {
		this.spentAmount = spentAmount;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
