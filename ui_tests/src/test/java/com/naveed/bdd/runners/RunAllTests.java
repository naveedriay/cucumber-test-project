package com.naveed.bdd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration(locations = {"file:/src/main/resources/spring-config.xml"})
@CucumberOptions(

        format = { "pretty", "html:target/cucumber" },
        glue = "com.naveed.bdd.step_defs",
        features = "classpath:features",
        tags = "~@pending", // ignore tests with pending tag (i.e. run test which are not pending)
        monochrome = true
)

public class RunAllTests {

}
