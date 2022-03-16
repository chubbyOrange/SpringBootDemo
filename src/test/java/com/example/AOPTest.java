package com.example;

import com.example.AOPDemo.TargetInterface;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AOPTest {
    @Autowired
    private TargetInterface targetInterface;

    @Test
    public void testAOP() {
        targetInterface.haveDinners();
    }
}
