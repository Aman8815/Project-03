package in.co.rays.project_3.dto;

public class PetrolPumpDTO extends BaseDTO{
	
	private String customerName ;
	
	private String fuelType;
	
     private Integer liters ;
	
	private Integer totalAmount ;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getLiters() {
		return liters;
	}

	public void setLiters(Integer liters) {
		this.liters = liters;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}



	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return customerName;
	}

}
