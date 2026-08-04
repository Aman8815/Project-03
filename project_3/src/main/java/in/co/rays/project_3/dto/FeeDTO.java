package in.co.rays.project_3.dto;

import java.util.Date;

public class FeeDTO  extends BaseDTO{
	
	private String studentId;
	
	private Integer amount;
	
	private Date paymentDate;
	
	private String paymentStatus;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return studentId;
	}

}
