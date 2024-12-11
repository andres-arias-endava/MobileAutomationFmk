package com.framework.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Elementos de la página
    @FindBy(id = "OutLineInputIds_textInputId")
    private WebElement usernameField;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"OutLineInputIds_textInputId\"]")// pedir ID unico
    private WebElement passwordField;

    @FindBy(id = "HelpLabelComponentIds_helpLabelClickHereText")
    private WebElement signInButtonHome;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Sign In\"]")
    private WebElement loginButtonSingIn;

    @FindBy(id = "If you've used the app before.")
    private WebElement hideKeyboard;

    // Constructor
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    // Métodos de interacción
    public LoginPage enterGrameenId(String username) {
        sendKeys(usernameField, username);
        return this;
    }

    public LoginPage hideKeyboardIos(){
        clickOn(hideKeyboard);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordField, password);
        return this;
    }

    public LoginPage loginButtonEnter(){
        clickOn(loginButtonSingIn);
        return this;
    }

    public HomePage clickSignInButton() {
        clickOn(signInButtonHome);
        return new HomePage(driver);
    }
}
