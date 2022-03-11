package com.example.AnnotationDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * javadoc 注解
 * 
 * @author mason
 * @version 1.0
 * @since jdk1.5
 */
@Properties(className = "com.example.AnnotationDemo.Student", methodName = "eat")
public class AnnotationDemo {
    /**
     * 计算两数之和
     * 
     * @param a 整数
     * @param b 整数
     * @return 两数之和
     */
    @Deprecated
    public int add(int a, int b) {
        return a + b;
    }

    public void addCall() {
        int a = 1, b = 2;
        add(a, b);
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        // * 解析注解
        // * 1. 获取该类的字节码文件对象
        Class<AnnotationDemo> annotationDemoClass = AnnotationDemo.class;
        // * 2. 获取上面的注解对象
        // * 实际就是在内存中生成了一个该注解接口的子类实现对象
        /**
         * public class propertiesImpl implements Properties {
         * ----public String className(){
         * --------return "com.example.AnnotationDemo.Student.java";
         * ----}
         * 
         * ----public String methodName(){
         * --------return "eat";
         * ----}
         * }
         */
        Properties properties = annotationDemoClass.getAnnotation(Properties.class);
        // * 3. 调用注解对象中定义的抽象方法，获取返回值
        String className = properties.className();
        String methodName = properties.methodName();
        System.out.println("className = " + className);

        // * 4.加载该类进内存
        Class<?> aClass = Class.forName(className);

        // * 5.创建对象
        // Object newInstance = aClass.newInstance();
        Class<Student> studentClass = Student.class;
        Constructor<?> ctor = studentClass.getConstructor();
        Object object = ctor.newInstance();

        // * 6.获取方法对象
        Method aMethod = aClass.getMethod(methodName);

        // * 7.执行方法
        aMethod.invoke(object);
    }
}
