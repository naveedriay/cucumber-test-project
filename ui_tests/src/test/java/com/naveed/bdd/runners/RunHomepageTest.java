package com.naveed.bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;


@RunWith(Cucumber.class)
@ContextConfiguration(locations = {"file:/src/main/resources/spring-config.xml"})
//@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "com.naveed.bdd.step_defs", // if com.naveed.bdd.step_defs will look for step definitions in all possible step under it
        features = "classpath:features/homepage.feature",// if you mention classpath:features will run all features under it
        tags = "~@pending", // ignore tests with pending tag (i.e. run test which are not pending)
        monochrome = true
)

public class RunHomepageTest {

}
