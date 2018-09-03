package com.smartrecruiter;

import com.smartrecruiter.processor.RequestProcessor;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by adnan on 9/3/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootConsoleApplication.class)
public class TestNearestEarthQuake {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private RequestProcessor processor;

    @Test
    public void testFiveNearestEarthQuake(){
        processor.findClosestEarthQuake(-73.935242, 40.730610, 5);
        assertTrue(systemOutRule.getLog().contains("Count: 5"));
    }

    @Test
    public void testTenNearestEarthQuake(){
        processor.findClosestEarthQuake(-73.935242, 40.730610, 10);
        assertTrue(systemOutRule.getLog().contains("Count: 10"));
    }

    @After
    public void tearDown(){
        systemOutRule.clearLog();
    }
}