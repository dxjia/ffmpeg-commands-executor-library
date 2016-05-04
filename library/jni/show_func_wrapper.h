#ifndef DXJIA_SHOW_FUNC_WRAPPER_H
#define DXJIA_SHOW_FUNC_WRAPPER_H

#include <string.h>
#include <stdint.h>
#include <stdlib.h>
#include <errno.h>
#include <math.h>

#include "libavutil/log.h"

#include <android/log.h>

void record_show_function_result(void* avcl, int level, const char* fmt, ...);
void reset_record();

char * get_record_result();

#define RECORD(a, b, x...) record_show_function_result(a, b, x)

#define RECORD_P(x...) record_show_function_result(NULL, 0, x)

#endif /* DXJIA_SHOW_FUNC_WRAPPER_H */