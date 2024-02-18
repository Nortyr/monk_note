package com.mountain.monk.jvm;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();

        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

    }
}
