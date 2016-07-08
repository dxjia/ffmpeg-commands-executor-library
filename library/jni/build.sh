#!/bin/sh
ndk-build APP_ABI=armeabi
mv ../libs/armeabi ../libs/armeabi-bak
ndk-build APP_ABI=x86
mv ../libs/armeabi-bak ../libs/armeabi