package com.why.project.webutilsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.why.project.webutilsdemo.utils.WebUtils;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String md5= WebUtils.MD5("password");
		Log.w("MainActivity","md5="+md5);
	}
}
