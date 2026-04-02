package in.co.rays.project_3.dto;

import java.util.Date;

public class LoanDTO  extends BaseDTO{
	
	private String lenderName;
	private Long loanAmount;
	private Long interestRate;
	private Date maturityDate;
	
	
	public String getLenderName() {
		return lenderName;
	}
	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Long getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Long interestRate) {
		this.interestRate = interestRate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return lenderName+"";
	}

}
