package page;

import org.openqa.selenium.WebDriver;

public class MainPage  extends BasePage {
    public final String myAccount="//span[contains(text(),'Giriş Yap')]";
    public  final String loginButton="//a[@id='login']";
    public final String productSearch="[placeholder='Ürün, kategori veya marka ara']";


    public MainPage(WebDriver driver) {
        super(driver);
    }



}
