package com.seamount.jdk.java.lang;

public class HelloJNI {


    /**
     * nativa 声明告诉jvm次方法的定义在外部，用c语言实现
     */
    private native void helloJNI();

    static {
        // loadLibrary 加载动态库，程序中helloJNI方法并没有具体实现，但是下面要调用此方法，这个时候就需要用static代码块进行初始化
        System.loadLibrary("helloJNI");
    }

    public static void main(String[] args) {
        HelloJNI jni = new HelloJNI();
        jni.helloJNI();
    }
}
