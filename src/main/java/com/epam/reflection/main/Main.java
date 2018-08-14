package com.epam.reflection.main;

import com.epam.reflection.example.IExample;
import com.epam.reflection.for_proxy.ForProxy;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        ForProxy forProxy = new ForProxy();
        Class forProxyClass = forProxy.getClass();

        Field exampleField = forProxyClass.getDeclaredField("example");

        boolean accessible = exampleField.isAccessible();
        exampleField.setAccessible(true);
        Object exampleObject = exampleField.get(forProxy);

        IExample proxy = (IExample) Proxy.newProxyInstance(Main.class.getClassLoader(), exampleObject.getClass().getInterfaces(), new InvocationHandler() {
            @SneakyThrows
            public Object invoke(Object proxyObject, Method invokedMethod, Object[] args) {
                String result = (String) invokedMethod.invoke(exampleObject);
                return "<" + result + ">";
            }
        });

        exampleField.set(forProxy, proxy);
        exampleField.setAccessible(accessible);

        forProxy.invokeExampleMethod();
        System.out.println("Commit2");
    }
}
