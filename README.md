`as version` <br>
<br><br>
# ffmpeg-commands-executor-library
execute ffmpeg commands as a shared library
# Usage
### 1. add dependency in your gradle file
```
compile 'cn.dxjia:ffmpegexecutor:0.1.4'
```
### 2. import package
```
import cn.dxjia.ffmpeg.library.FFmpegNativeHelper;
```

### 3. init ffmpeg
init ffmpeg in somewhere, like onCreate(), call once.
```
    FFmpegNativeHelper.ffmpeg_init();
```
### 4. run command
```
   FFmpegNativeHelper.runCommand("ffmpeg -version");
```

### 5. uninit
call uninit when you dont need to use ffmpeg again
```
    FFmpegNativeHelper.ffmpeg_uninit();
````
# Compile library by yourself
### Step 1
 Build jni manually
#### Linux or Ubuntu
```
cd library/jni
chmod a+x build.sh
. build.sh
```
#### Windows
Make sure you have add you NDK path to your PC Enviroment.
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
