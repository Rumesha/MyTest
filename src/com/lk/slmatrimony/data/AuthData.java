package com.lk.slmatrimony.data;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.lk.slmatrimony.dto.AuthDTO;



public class AuthData  {
	
	
	@SerializedName("data")
	AuthDTO userData;

	public AuthDTO getUserData() {
		return userData;
	}

	public void setUserData(AuthDTO userData) {
		this.userData = userData;
	}

	

	
	
	

}
