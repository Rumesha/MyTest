package com.lk.slmatrimony.activities;

import com.lk.slmatrimony.R;

import android.app.Activity;

public class SearchAcivity extends Activity {
	
	
	
	
	
	@Override
	public void onBackPressed() {
		
		super.onBackPressed();
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
	}

}
