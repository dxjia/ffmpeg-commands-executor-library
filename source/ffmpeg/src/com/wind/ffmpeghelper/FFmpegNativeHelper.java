package com.wind.ffmpeghelper;

import android.util.Log;

public class FFmpegNativeHelper {
	public FFmpegNativeHelper() {
	}
	
	static {
		System.loadLibrary("avutil-54");
		System.loadLibrary("swresample-1");
		System.loadLibrary("avcodec-56");
		System.loadLibrary("avformat-56");
		System.loadLibrary("swscale-3");
		System.loadLibrary("avfilter-5");
		System.loadLibrary("avdevice-56");
		System.loadLibrary("ffmpegjni");
	}

	// success 0, error 1
	public int ffmpegRunCommand(String command) {
		if(command.isEmpty()) {
			return 1;			
		}
		String[] args = command.split(" ");
		for(int i = 0; i < args.length; i++) {
			Log.d("ffmpeg-jni", args[i]);
			
		}
		return ffmpeg_entry(args);
	}

	// argc maybe dont be needed
	public native int ffmpeg_init();
	public native int ffmpeg_uninit();
	public native int ffmpeg_entry(String[] args);
}
