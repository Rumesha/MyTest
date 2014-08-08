package com.lk.slmatrimony.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.lk.slmatrimony.R;
import com.lk.slmatromony.viewitems.MainIcon;


public class HomeActivity extends Activity implements OnClickListener{
	
	MainIcon search;
	MainIcon myMatches;
	MainIcon interests;
	MainIcon daialy5;
	MainIcon surprise;
	MainIcon upgrade;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getActionBar().setCustomView(R.layout.action_bar_layout);
		
		initUI();

		
		
	}
	
	void initUI(){
		
		search=(MainIcon) findViewById(R.id.profile_icon);
		myMatches=(MainIcon) findViewById(R.id.search_icon);
		interests=(MainIcon) findViewById(R.id.interests_icon);
		daialy5=(MainIcon) findViewById(R.id.interests_icon);
		surprise=(MainIcon) findViewById(R.id.surprise_me_icon);
		upgrade=(MainIcon) findViewById(R.id.upgrade_icon);
		
		search.setOnClickListener(this);
		myMatches.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		
		case R.id.profile_icon:
			
			Intent intent=new Intent(this,ProfileActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
			
			
			break;
			
		case R.id.search_icon:
			
			break;
		case R.id.interests_icon:
	
			break;
		case R.id.daily_five:
	
			break;
		case R.id.surprise_me_icon:
	
			break;
		case R.id.upgrade_icon:
	
			break;
		

		default:
			break;
		}
		
		
	}

	

}
