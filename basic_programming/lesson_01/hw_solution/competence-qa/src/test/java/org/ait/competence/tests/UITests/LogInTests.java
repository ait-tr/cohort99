package org.ait.competence.tests.UITests;

import org.ait.competence.pages.LandingPage;
import org.ait.competence.pages.LogInPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new LandingPage(driver, js).selectLogIn();
    }

    @Test
    public void logInPositiveTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new LogInPage(driver, js)
                .logIn("Student33@gmail.com", "Qwerty007!")
                .verifyLogOutBtnIsPresent();
    }

    @Test
    public void logInNegativeTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new LogInPage(driver, js)
                .logIn("Student1@gmail.com", "Qwerty007")
                .verifyErrorMessageIsPresent();
    }

}
