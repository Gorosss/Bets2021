package domain;

import javax.persistence.Id;

public class UserName {

	@Id
	private String userName;

	public UserName(String pUserName) {
		this.userName=pUserName;
	}

	public String getUserName() {
		return userName;
	}

}