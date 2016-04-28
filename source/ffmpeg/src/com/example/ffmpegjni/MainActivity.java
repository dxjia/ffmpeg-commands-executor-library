package com.example.ffmpegjni;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.wind.ffmpeghelper.FFmpegNativeHelper;

public class MainActivity extends Activity {

	TextView mTextView = null;
	FFmpegNativeHelper mFfmpegNativeHelper = null;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text_view);
        mFfmpegNativeHelper = new FFmpegNativeHelper();
        mFfmpegNativeHelper.ffmpeg_init();
    }

    protected void onDestroy() {
        super.onDestroy();
        mFfmpegNativeHelper.ffmpeg_uninit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("Setting");
		return true;
    }

	private static final String testCommand = "ffmpeg -i /sdcard/abc.mp4 -vframes 30 -y -f gif /sdcard/outabc.gif";
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	// TODO: do jni testthing
    	if (mFfmpegNativeHelper.ffmpegRunCommand(testCommand) == 0) {
    	    mTextView.setText("success!");
    	} else {
    		mTextView.setText("failed!");    		
    	}
    	return super.onOptionsItemSelected(item);
    } 
}
