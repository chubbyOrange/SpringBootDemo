package com.example.DynamicProxyDemo.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JulieProxy implements InvocationHandler {
    private Girl girl;

    public JulieProxy(Girl girl) {
        this.girl = girl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // * Auto-generated method stub
        doSomethingBefore();
        Object object = method.invoke(girl, args);
        doSomethingAfter();

        return object;
    }

    private void doSomethingAfter() {
        System.out.println("Julie's parents ask: \"Was he rude to you?\"");
    }

    private void doSomethingBefore() {
        System.out.println("Julie's parents say: \"We need to investigate this boy first.\"");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }
}
