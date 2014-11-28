package com.sismatik.dhananjay;

import org.apache.cordova.*;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
public class MainActivity extends DroidGap {
	String emailaddress[]={"reachme@dhananjaisingh.com"};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 super.onCreate(savedInstanceState);
		    super.init(); // Calling this is necessary to make this work
		    appView.addJavascriptInterface(this, "MainActivity");

		    /* "this" points the to the object of the current activity. "MainActivity" is used to refer "this" object in JavaScript as in Step 3. */

		    super.loadUrl("file:///android_asset/www/index.html");
	}
	@JavascriptInterface 
	public void customFunctionCalled() {
		
		Intent emailIntent = new Intent(Intent.ACTION_SEND) ;
		
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);
		emailIntent.setType("plain/text");
		startActivity(emailIntent);
	}
}
