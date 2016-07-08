call ndk-build APP_ABI=armeabi
ren ..\libs\armeabi armeabi-bak
call ndk-build APP_ABI=x86
ren ..\libs\armeabi-bak armeabi
