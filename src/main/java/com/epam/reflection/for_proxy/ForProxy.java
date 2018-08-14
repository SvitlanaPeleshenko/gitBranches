package com.epam.reflection.for_proxy;

import com.epam.reflection.example.IExample;
import com.epam.reflection.example.implementation.Example;

public class ForProxy {
    private IExample example = new Example();

    public void invokeExampleMethod() {
        System.out.println(example.method());
    }
}
