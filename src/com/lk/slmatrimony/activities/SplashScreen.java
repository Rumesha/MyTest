package com.lk.slmatrimony.activities;

import com.lk.slmatrimony.R;
import com.lk.slmatrimony.R.anim;
import com.lk.slmatrimony.R.id;
import com.lk.slmatrimony.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SplashScreen extends Activity {
	
	ImageView logo;
	Animation alpha;
	Animation translate;
	RelativeLayout layout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen_layout);
		showSplashSceen();
		
	}
	
	
	void showSplashSceen(){
		logo=(ImageView) findViewById(R.id.logo);
		alpha=AnimationUtils.loadAnimation(this,R.anim.alpha);
		translate=AnimationUtils.loadAnimation(this,R.anim.translate);
		layout=(RelativeLayout) findViewById(R.id.RelativeLayout1);
		
		alpha.reset();
		layout.clearAnimation();
		layout.startAnimation(alpha);
		translate.reset();
		logo.clearAnimation();
		logo.startAnimation(translate);

		translate.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {

			}

			public void onAnimationRepeat(Animation animation) {

			}

			public void onAnimationEnd(Animation animation) {

				Intent intent=new Intent(SplashScreen.this,LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
				finish();
			}
		});
	}
	
	
	

}
