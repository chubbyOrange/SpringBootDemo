package com.example.DynamicProxyDemo.Cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Mason {
    public static void main(String[] args) {
        Julie girl = new Julie();

        // * 1. 创建增强器
        Enhancer enhancer = new Enhancer();

        // * 2. 设置父类（目标）
        enhancer.setSuperclass(Julie.class);

        // * 3. 设置回调
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                // TODO Auto-generated method stub
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
        };

        enhancer.setCallback(methodInterceptor);

        // * 4. 创建代理对象
        Julie mother = (Julie) enhancer.create();

        // JulieProxy family = new JulieProxy(julie);
        // Girl mother = family.getProxyInstance();
        mother.watchMovies();
        System.out.println("-----------------------");
        mother.haveDinners();
    }
}
