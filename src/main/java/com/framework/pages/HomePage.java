package com.framework.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(id = "com.tuempresa:id/logout_button")
    private WebElement logoutButton;

    @FindBy(id = "OnBoardingInfoComponentIds_getStartedButton")
    private WebElement getStartedButton;

    @FindBy(id = "welcome_message_id") // Supongamos que este es el ID del mensaje de bienvenida
    private WebElement welcomeMessage;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).getText();
    }

    public boolean isLoggedIn() {
        return isElementDisplayed(welcomeMessage);
    }

    public LoginPage clickLogoutButton() {
        clickOn(logoutButton);
        return new LoginPage(driver);
    }

    public LoginPage clickGetReadyButton() {
        clickOn(getStartedButton);
        return new LoginPage(driver); // Si el clic te lleva a otra página, devuelve la instancia de esa página
    }

}
