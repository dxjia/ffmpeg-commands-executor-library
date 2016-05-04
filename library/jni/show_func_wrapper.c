#include "show_func_wrapper.h"

#include "android_log.h"

#define UNUSED(a) (void*)(a);

#define MAX_SIZE 4096
#define RECORD_LINE_SZ 2048

static int show_function_result_position = 0;
static char record_result[MAX_SIZE];
static char record_line[RECORD_LINE_SZ];
static int print_prefix = 1;

void record_show_function_result(void* avcl, int level, const char* fmt, ...) {
    int len;
    char * record;
    va_list ap;
    va_start(ap, fmt);

    UNUSED(avcl);
    UNUSED(level);

    memset(record_line, '\0', RECORD_LINE_SZ);
    av_log_format_line(NULL, AV_LOG_INFO, fmt, ap, record_line, RECORD_LINE_SZ, &print_prefix);
    len = strlen(record_line);
    record = record_result + show_function_result_position;
    strncpy(record, record_line, len);
    show_function_result_position += len;

    if (show_function_result_position >= MAX_SIZE) {
        show_function_result_position -= len;
        record_result[show_function_result_position] = '\0';
    }

    va_end(ap);
}

void reset_record() {
    show_function_result_position = 0;
    memset(record_result, '\0', MAX_SIZE);
    logd("reset_record done!");
}

char * get_record_result() {
    if (show_function_result_position == 0) {
        return NULL;
    }
    return record_result;
}