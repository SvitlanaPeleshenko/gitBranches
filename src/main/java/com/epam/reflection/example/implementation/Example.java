package com.epam.reflection.example.implementation;

import com.epam.reflection.example.IExample;

public class Example implements IExample {
    @Override
    public String method() {
        return "EPAM";
    }
}
