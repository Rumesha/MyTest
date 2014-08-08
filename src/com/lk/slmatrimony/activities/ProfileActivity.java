package com.lk.slmatrimony.activities;

import com.lk.slmatrimony.R;

import android.app.Activity;
import android.os.Bundle;

public class ProfileActivity extends Activity {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setTitle(getString(R.string.profile));
		setContentView(R.layout.profile_layout);
	}

}
