package in.co.rays.project_3.dto;

import java.util.Date;

public class ScholarshipDTO extends BaseDTO {
	
  private String	scholarshipName;
  private Integer amount;
  private String eligibility;
  private Date lastDate;
  
  
  

	public String getScholarshipName() {
	return scholarshipName;
}

public void setScholarshipName(String scholarshipName) {
	this.scholarshipName = scholarshipName;
}

public Integer getAmount() {
	return amount;
}

public void setAmount(Integer amount) {
	this.amount = amount;
}

public String getEligibility() {
	return eligibility;
}

public void setEligibility(String eligibility) {
	this.eligibility = eligibility;
}

public Date getLastDate() {
	return lastDate;
}

public void setLastDate(Date lastDate) {
	this.lastDate = lastDate;
}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+" ";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return  scholarshipName;
	}

}
