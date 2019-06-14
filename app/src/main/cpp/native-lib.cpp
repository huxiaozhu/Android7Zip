#include <jni.h>

extern "C"
JNIEXPORT jint JNICALL
Java_com_huxiaozhu_a7zip_ZipUtils_excuteCommand(JNIEnv *env, jclass type, jstring command_) {
    jint a = 12;
    return a;
}