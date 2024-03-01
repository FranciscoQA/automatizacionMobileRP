package com.bdd.runner;

import environment.SystemEnvironmentVariables;
import io.cucumber.junit.CucumberOptions;
import io.restassured.response.Response;
import mobile.com.bdd.jxray.dom.JXrayProperties;
import mobile.com.bdd.jxray.dom.JXrayServiceDom;
import mobile.com.bdd.jxray.help.JXrayHelperCredentials;
import mobile.com.bdd.lib.MobileDriverManager;
import mobile.com.bdd.util.UtilMobile;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;

import static environment.ManageEnvironment.getEnvironment;
import static environment.ManageEnvironment.setEnvironment;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features/"},
        stepNotifications = true,
        glue = {"com.bdd.stepdefinition"},
        tags = "@LOGIN_REAL_PLAZA"
       // plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:resources/cucumber-reports/report.html"}
)
public class RunnerTest {

    @BeforeClass
    public static void beforeExecution() {
        UtilMobile.logger(RunnerTest.class).info("BEFORE >>>");
        setEnvironment(SystemEnvironmentVariables.createEnvironmentVariables());
    }

    @AfterClass
    public static void afterExecution() {
        UtilMobile.logger(RunnerTest.class).info("AFTER >>>");
        //Se detiene el driver.
        MobileDriverManager.stopMobileDriver();

        String cucumberJsonPath = System.getProperty("user.dir") + "/target/build/cucumber.json";
        boolean isJiraOn = UtilMobile.getBooleanEvironmentProperty(getEnvironment(), JXrayProperties.JXRAY_EVIDENCE);

        if (isJiraOn) {
            UtilMobile.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
            JXrayServiceDom jXrayServiceDom = new JXrayServiceDom();
            Response response = jXrayServiceDom.importTestResultExecution(
                    new JXrayHelperCredentials(getEnvironment()).getJiraHost(),
                    cucumberJsonPath,
                    new JXrayHelperCredentials(getEnvironment()).getJXrayUser(),
                    new JXrayHelperCredentials(getEnvironment()).getJXrayPassword());
            response.then().assertThat().statusCode(200);
        } else {
            UtilMobile.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
        }

    }
}