LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE :=ApkPatch
LOCAL_SRC_FILES := com_sqq_updateapk_DiffUtils.c com_sqq_updateapk_PatchUtils.c

LOCAL_LDLIBS     := -lz

LOCAL_ALLOW_UNDEFINED_SYMBOLS := true
include $(BUILD_SHARED_LIBRARY)