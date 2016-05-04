#!/bin/sh
ndk-build
mv ../libs/armeabi ../libs/armeabi-bak
ndk-build APP_ABI=x86
mv ../libs/armeabi-bak ../libs/armeabi