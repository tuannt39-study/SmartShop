package vn.its.rest.model;

import java.sql.Timestamp;

public class Login {
	private long id;
	private long userID;
	private String token;
	private Timestamp lastAccess;

	public Login() {
		
	}
}
