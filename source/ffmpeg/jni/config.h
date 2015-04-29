#ifndef DXJIA_FFMPEG_CONFIG_H
#define DXJIA_FFMPEG_CONFIG_H

#if USE_ARM_CONFIG
#include "arm_config.h"
#elif USE_X86_CONFIG
#include "x86_config.h"
#endif

#endif /* DXJIA_FFMPEG_CONFIG_H */
