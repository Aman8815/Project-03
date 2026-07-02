package in.co.rays.project_3.dto;

public class WaterDTO extends BaseDTO{
	
	private String waterCode;
	private String location;
	private Long waterLevel;
	private String status;

	public String getWaterCode() {
		return waterCode;
	}

	public void setWaterCode(String waterCode) {
		this.waterCode = waterCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(Long waterLevel) {
		this.waterLevel = waterLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return waterCode;
	}

}
