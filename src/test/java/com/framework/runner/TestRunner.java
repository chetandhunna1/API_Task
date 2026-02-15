package com.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.framework.steps",
        plugin = {"pretty"}, // No JSON or HTML plugin
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
