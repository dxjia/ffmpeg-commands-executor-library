call ndk-build
ren ..\libs\armeabi armeabi-bak
call ndk-build APP_ABI=x86
ren ..\libs\armeabi-bak armeabi