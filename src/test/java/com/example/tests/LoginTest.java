package com.example.tests;

import com.example.framework.base.BaseTest;
import com.example.framework.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        setup("android"); // Switch to "ios" if you are testing iOS
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("test_user");
        loginPage.enterPassword("test_password");
        loginPage.clickLogin();
        // Add assertion
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
