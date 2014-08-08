package com.lk.slmatrimony.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.lk.slmatrimony.R;
import com.lk.slmatrimony.constants.MatrimonyConstants;
import com.lk.slmatrimony.dao.AuthDAO;
import com.lk.slmatrimony.dao.AuthDAO.AuthCallBackInterface;
import com.lk.slmatrimony.data.AuthData;
import com.lk.slmatrimony.dto.AuthDTO;

public class LoginActivity extends Activity implements OnClickListener,AuthCallBackInterface {
	
	EditText userName;
	EditText password;
	Button loginBtn;
	Button signUpBtn;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		initUi();
		
		
	}
	
	void initUi(){
		
		userName=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
		loginBtn=(Button) findViewById(R.id.login_btn);
		signUpBtn=(Button) findViewById(R.id.signup_btn);
		loginBtn.setOnClickListener(this);
		signUpBtn.setOnClickListener(this);
		
		
		
		
	}
	
	
	private void login(String username,String password){
		
		 AuthDAO auth=new AuthDAO(this,this);
 		 auth.sendLoginRequest(username,password);
	}
	
	
	private void showHomescreen(){
		
		Intent intent=new Intent(this,HomeActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
		finish();
		
	}
	
	
	private void gotoSignUp() {
		
		Intent intent=new Intent(this,SignUpActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
		//finish();
		
	}
	
	

	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		case R.id.login_btn:
			
			login(userName.getText().toString(),password.getText().toString());
			
			break;
		case R.id.signup_btn:
			
			gotoSignUp();
			
			break;

		default:
			break;
		}
		
		
		
	}

	@Override
	public void onGetTokenComplete(AuthData authData) {
		
		
		System.out.println("ffff "+authData.getUserData().getMessage());
		
		if(authData.getUserData().getUser()!=null){
			showHomescreen();
		}
		
		/*if(authData.getUserData().getSuccess().equals(MatrimonyConstants.RESPONSE_OK)){
			showHomescreen();
		}*/
	}

	@Override
	public void onGetTokenError(VolleyError error) { 
	
		System.out.println("error"+error.getMessage());
	}

	
}
