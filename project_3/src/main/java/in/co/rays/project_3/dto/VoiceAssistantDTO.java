package in.co.rays.project_3.dto;

public class VoiceAssistantDTO  extends BaseDTO{
	
	private  String userVoice;
	private  String response;
	private  String language;
	private  int accuracy;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return userVoice;
	}

	public String getUserVoice() {
		return userVoice;
	}

	public void setUserVoice(String userVoice) {
		this.userVoice = userVoice;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

}
