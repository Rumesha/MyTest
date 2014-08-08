package com.lk.slmatromony.viewitems;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lk.slmatrimony.R;


public class MainIcon extends RelativeLayout {
	
	Drawable icon;
	String title;
	
	LayoutInflater inflator;
	
	
    
	
	
	Context context;
	
	public MainIcon(Context context){
		
		super(context);
		LayoutInflater.from(context).inflate(R.layout.icon_view, this);
		
	}
	public MainIcon(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context,attrs);
		
	}
	
	
	
	public MainIcon(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs);
		//init(context,attrs);
	}
	
	void init(Context context, AttributeSet attrs){
		
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.MainIcon, 0, 0);
		
		try {
			
			title=a.getString(R.styleable.MainIcon_title);
			icon=a.getDrawable(R.styleable.MainIcon_iconresource);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			a.recycle();
		}
		
		LayoutInflater.from(context).inflate(R.layout.icon_view, this);
		Typeface font = Typeface.createFromAsset(context.getAssets(), "Roboto-Thin.ttf");
		
		TextView captcha=(TextView) this.findViewById(R.id.title);
		ImageView image=(ImageView) this.findViewById(R.id.icon);
		captcha.setText(title);
		captcha.setTypeface(font,Typeface.BOLD);
		
		System.out.println("ICON "+icon);
		image.setBackgroundDrawable(icon);
		
	}
	public Drawable getIcon() {
		return icon;
	}
	public void setIcon(Drawable icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
