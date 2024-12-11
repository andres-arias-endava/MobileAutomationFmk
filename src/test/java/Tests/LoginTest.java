package Tests;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        // Inicializar la página de inicio de sesión
        LoginPage loginPage = new LoginPage(driver);

        // Realizar las acciones de inicio de sesión
        HomePage homePage = loginPage.clickSignInButton();

        loginPage.enterGrameenId("696330209").enterPassword("Test123*");
        loginPage.hideKeyboardIos();
        loginPage.loginButtonEnter();


        // Verificar que el inicio de sesión fue exitoso
        Assert.assertTrue(homePage.isLoggedIn(), "El usuario no pudo iniciar sesión correctamente.");
    }
}
