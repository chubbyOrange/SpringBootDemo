package com.example.DynamicProxyDemo.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JulieProxy implements InvocationHandler {
    private Girl girl;

    public JulieProxy(Girl girl) {
        this.girl = girl;
    }

    /**
     * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
     * 参数：
     * 1. proxy：代理对象
     * 2. method：代理对象调用的方法被封装为的对象
     * 3. args：代理对象调用方法时传递的实际参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // * Auto-generated method stub
        // System.out.println(method.getName());
        // System.out.println(args[0]);
        Object object = null;
        StringBuilder adjConcat = new StringBuilder((String) args[0]);

        doSomethingBefore();

        // * 增强参数
        if (method.getName().equals("watchMovies")) {
            adjConcat.append(". I love the protagonist");
        }

        // * 使用真实对象调用该方法
        object = method.invoke(girl, adjConcat.toString());
        doSomethingAfter();

        // * 增强返回值
        if (method.getName().equals("haveDinners")) {
            return (String) object + "\"Oh, right. And the vibe in the restaurant is dope!\"";
        }

        return object;
    }

    private void doSomethingAfter() {
        System.out.println("Julie's parents ask: \"Was he rude to you?\"");
    }

    private void doSomethingBefore() {
        System.out.println("Julie's parents say: \"We need to investigate this boy first.\"");
    }

    public Object getProxyInstance() {
        /**
         * 三个参数：
         * 1. 类加载器：真实对象.getClass().getClassLoader()
         * 2. 接口数组：真实对象.getClass().getInterfaces()
         * 3. 处理器：new InvocationHandler()
         */
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }
}
