ifeq ($(APP_ABI), x86)
include Android.x86.mk
else
include Android.arm.mk
endif

