package in.co.rays.project_3.dto;

import java.util.Date;

public class RefundDTO  extends BaseDTO{
	
	private String refundCode;

	private String refundAmount;

	private Date refundDate;

	private String refundStatus;
      
	public String getRefundCode() {
		return refundCode;
	}

	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id +"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return refundCode+"";
	}

}
