package in.co.rays.project_3.dto;

public class SmartDTO  extends BaseDTO{
	
	private String lightCode;
	private String roomName;
	private Long brightnessLevel;
	private String status;

	public String getLightCode() {
		return lightCode;
	}

	public void setLightCode(String lightCode) {
		this.lightCode = lightCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Long getBrightnessLevel() {
		return brightnessLevel;
	}

	public void setBrightnessLevel(Long brightnessLevel) {
		this.brightnessLevel = brightnessLevel;
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
		return lightCode;
	}

}
