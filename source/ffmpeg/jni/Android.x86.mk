LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE:= avcodec-prebuilt-x86
LOCAL_SRC_FILES:= prebuilt/x86/libavcodec-56.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE:= avdevice-prebuilt-x86
LOCAL_SRC_FILES:= prebuilt/x86/libavdevice-56.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE:= avfilter-prebuilt-x86
LOCAL_SRC_FILES:= prebuilt/x86/libavfilter-5.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE:= avformat-prebuilt-x86
LOCAL_SRC_FILES:= prebuilt/x86/libavformat-56.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=  avutil-prebuilt-x86
LOCAL_SRC_FILES := prebuilt/x86/libavutil-54.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := swresample-prebuilt-x86
LOCAL_SRC_FILES := prebuilt/x86/libswresample-1.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := swscale-prebuilt-x86
LOCAL_SRC_FILES := prebuilt/x86/libswscale-3.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)

TARGET_ARCH:=x86
TARGET_ARCH_ABI:=x86

LOCAL_MODULE := libffmpegjni

LOCAL_SRC_FILES := FFmpegNativeHelper.c \
                   cmdutils.c \
                   ffmpeg_opt.c \
                   ffmpeg_filter.c

LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog -lz

LOCAL_SHARED_LIBRARIES:= avcodec-prebuilt-x86 \
                         avdevice-prebuilt-x86 \
                         avfilter-prebuilt-x86 \
                         avformat-prebuilt-x86 \
                         avutil-prebuilt-x86 \
                         swresample-prebuilt-x86 \
                         swscale-prebuilt-x86

LOCAL_C_INCLUDES += -L$(SYSROOT)/usr/include
LOCAL_C_INCLUDES += $(LOCAL_PATH)/include

LOCAL_CFLAGS := -DUSE_X86_CONFIG

include $(BUILD_SHARED_LIBRARY)
