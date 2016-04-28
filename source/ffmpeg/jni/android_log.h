#ifndef DXJIA_ANDROID_LOG_H
#define DXJIA_ANDROID_LOG_H

#include "libavutil/log.h"

#define LOG_TAG "ffmpeg-jni"
#include <android/log.h>

#define logv(...) __android_log_print(ANDROID_LOG_VERBOSE, LOG_TAG ,__VA_ARGS__)
#define logd(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG ,__VA_ARGS__)
#define logi(...) __android_log_print(ANDROID_LOG_INFO,  LOG_TAG ,__VA_ARGS__)
#define logw(...) __android_log_print(ANDROID_LOG_WARN,  LOG_TAG ,__VA_ARGS__)
#define loge(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG ,__VA_ARGS__)
#define logf(...) __android_log_print(ANDROID_LOG_FATAL, LOG_TAG ,__VA_ARGS__)

void log_callback(void *ptr, int level, const char *fmt, va_list vl);
void log_anyway(void *ptr, int level, const char *fmt, va_list vl);

static printf_log(const char* fmt, ...) {
    va_list ap;
    va_start(ap, fmt);
    log_anyway(NULL, AV_LOG_INFO, fmt, ap);
    va_end(ap);
}

#define printf(x...) printf_log(x)


#endif /* DXJIA_ANDROID_LOG_H */
