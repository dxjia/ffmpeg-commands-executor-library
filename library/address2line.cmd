@echo off
set CURRENT_PATH=%cd%

set LIB_FILE_PATH=%CURRENT_PATH%\obj\local\armeabi\%1%
set CRASH_ADRESS=%2%

set TOOL_PATH="D:\android\android-ndk\toolchains\arm-linux-androideabi-4.8\prebuilt\windows\bin\arm-linux-androideabi-addr2line.exe"

"%TOOL_PATH%" -C -f -e "%LIB_FILE_PATH%" "%CRASH_ADRESS%" SHELL=cmd %*