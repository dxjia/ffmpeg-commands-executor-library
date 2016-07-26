`This is AS version` <br>
Eclipse version, please refer to [Old Eclipse Version](https://github.com/dxjia/ffmpeg-commands-executor-library/tree/master)
# ffmpeg-commands-executor-library
execute ffmpeg commands as a shared librar, you can try [example.apk](https://github.com/dxjia/ffmpeg-commands-executor-library/releases/download/v0.1.7/example-debug.apk)
<br>[**Note**]: This library may not support all the codecs you want, for example, h264.

# Usage
add dependency in your build.gradle
```
dependencies {
    compile 'cn.dxjia:ffmpegexecutor:0.1.7'
}
```
import package
```
import cn.dxjia.ffmpeg.library.FFmpegNativeHelper;
```
run command
```
FFmpegNativeHelper.runCommand("ffmpeg -version");
```

**`NOTE:`**
- now,  runCommand() will return some strings as result, not very friendly;
- this library modified some ffmpeg source code, invasion is relatively strong.

# Compile library or example by yourself
If you want to compile this library by yourself, you can do that as follow steps.
### Step 1
 Build jni manually
#### Linux or Ubuntu
```
cd library/jni
chmod a+x build.sh
. build.sh
```
#### Windows
Make sure you have add your NDK path to your PC Enviroment.
<br>
Open a CMD terminal
```
cd library\jni
build.cmd
```
### Step 2
Android Studio -> Open Existing Project

### Step 3
modify code & build project

**NOTE:** Every time you changed the jni source code, you need to build it manually before building the project from Android Studio.

Any issues and PRs are welcome.

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
