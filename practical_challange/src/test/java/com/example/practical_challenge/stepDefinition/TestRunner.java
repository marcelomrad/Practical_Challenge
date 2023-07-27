package com.example.practical_challenge.stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
        glue = "com.example.practical_challenge.stepDefinition"
)
public class TestRunner {
}
