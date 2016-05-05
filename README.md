可直接用于Android Studio 的aar版本请看 [Android Studio Version](https://github.com/dxjia/ffmpeg-commands-executor-library/tree/as-version)
<br><br>
# ffmpeg-commands-executor-library
使用jni调用ffmpeg，首先将so库编入apk，jni的实现上使用直接传递ffmpeg command的方式，这样只需要安排合适的ffmpeg命令即可完成工作，不用再去研究ffmpeg的函数调用。

# 介绍
项目使用`eclipse`创建。<br>
jni/prebuilt以及jni/include下的so和.h文件都是从我的另外一个项目[ffmpeg-for-android-shared-library](https://github.com/dxjia/ffmpeg-for-android-shared-library)得来的。<br>
### Step 1
#### Ubuntu
使用ndk将jni进行编译。<br>
本项目中增加了x86的ffmpeg库，但ndk-build要分别来进行。<br>
如果只想支持arm平台的设备，只需执行：<br>
```
cd jni
ndk-build
```
如果还需要支持x86平台的设备，则还需要再执行：<br>
```
ndk-build APP_ABI=x86
```
这里有一个问题：这样执行之后会将第一次ndk-build出来的armeabi下的so库清空掉，也许是makefile文件写的不够好，后面再研究一下修复<br>
请手动执行，将obj/local/armeabi下的所有so复制到libs/armeabi目录下：<br>
```
cp obj/local/armeabi/*.so libs/armeabi/
```
#### Windows
编辑下面这个文件
```
 .\source\ffmpeg\.externalToolBuilders\NDK_Builder.launch
```
将其中的`NDK`路径改为自己的:
```
<stringAttribute key="org.eclipse.ui.externaltools.ATTR_LOCATION" value="D:\android\android-ndk\ndk-build.cmd"/>
```
如果要编译`x86`版本，请将参数修改为`APP_ABI=x86`
```
<stringAttribute key="org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS" value="APP_ABI=arm"/>
```

### Step 3
eclipse --> File --> Import --> Android --> Existing Android Code Into Workspace --> 选择`.\source\ffmpeg`目录

### Step 4
build project

# 代码示例
## Java示例

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
## 使用
传入有效路径，如：/sdcard/abc.mp4<br>
```java
// 将/sdcard/abc.mp4从开始的30帧转换为gif图片
String testCommand = "ffmpeg -i /sdcard/abc.mp4 -vframes 30 -y -f gif /sdcard/outabc.gif";
new FFmpegNativeHelper().ffmpegRunCommand(testCommand);
```
# TODO
<font size="4">x86设备上还待验证</font>

# License
```
   Copyright (c) 2015 dxjia

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
