# ffmpeg-jni-sample
使用jni调用ffmpeg，首先将so库编入apk，jni的实现上使用直接传递ffmpeg command的方式，这样只需要安排合适的ffmpeg命令即可完成工作，不用再去研究ffmpeg的函数调用。

# 介绍
项目使用eclipse创建<br>
jni/prebuilt以及jni/include下的so和.h文件都是从项目[ffmpeg-for-android-shared-library](https://github.com/dxjia/ffmpeg-for-android-shared-library)得来的<br>
###Step 1
使用ndk将jni进行编译<br>
```
cd jni
ndk-build
```
###Step 2
eclipse import project

###Step 3
build project

#使用
##Java示例
```java
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
		return ffmpeg_entry(args.length, args);
	}

	// argc maybe dont be needed
	public native int ffmpeg_entry(int argc, String[] args);
}
```
##调用
```java
// 将/sdcard/abc.mp4从开始的30帧转换为gif图片
String testCommand = "ffmpeg -i /sdcard/abc.mp4 -vframes 30 -y -f gif /sdcard/outabc.gif";
new FFmpegNativeHelper().ffmpegRunCommand(testCommand);
```
