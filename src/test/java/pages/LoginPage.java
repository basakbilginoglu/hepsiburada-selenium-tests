package page;

import org.openqa.selenium.WebDriver;

public class LoginPage extends  BasePage{
    public final String emailAdress="txtUserName";
    public final String password="txtPassword";
    public final String loginButton= "btnLogin";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
