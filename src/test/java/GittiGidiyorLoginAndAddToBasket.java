import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GittiGidiyorLoginAndAddToBasket {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "properties/drivers/chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(opt);
        driver.navigate().to("https://www.gittigidiyor.com/");

        Actions action = new Actions(driver);
        WebElement loginHoverElement = driver.findElement(By.xpath("//div[@title='Giriş Yap']"));
        action.moveToElement(loginHoverElement).build().perform();
        Thread.sleep(5000);


        WebElement loginButtonElement = driver.findElement(By.xpath("//a[@data-cy='header-login-button']"));
        loginButtonElement.click();
        Thread.sleep(5000);

        WebElement userName = driver.findElement(By.id("L-UserNameField"));

        userName.sendKeys("numanhanduran@outlook.com");

        WebElement password = driver.findElement(By.id("L-PasswordField"));

        password.sendKeys("68626numanhan");

        WebElement loginButton = driver.findElement(By.id("gg-login-enter"));

        loginButton.click();
        Thread.sleep(5000);

        WebElement searchArea = driver.findElement(By.xpath("//input[@data-cy='header-search-input']"));
        WebElement searchArea2 = driver.findElement(By.xpath("//input[@data-cy='header-search-input']"));

        searchArea2.click();

        searchArea.sendKeys("bilgisayar");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-cy='search-find-button']"));

        searchButton.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        // Sayfayı en aşağı kadar scroll ediyorum burada sanırım maximize da browserın tamamen ekranı kaplaması durumu
        js.executeScript("window.scrollBy(0,7000)");


        WebElement secondPage = driver.findElement(By.xpath("//a[@href='/arama/?k=bilgisayar&sf=2']"));

        secondPage.click();


        WebElement randomProduct = driver.findElement(By.id("item-info-block-652682846"));

        randomProduct.click();


        String productPrice = driver.findElement(By.id("sp-price-highPrice")).getText();
        System.out.println("Ürün sayfasındaki fiyat = " + productPrice);


        WebElement addToBasketButton = driver.findElement(By.id("add-to-basket"));

        addToBasketButton.click();

        WebElement miniBasketButton = driver.findElement(By.xpath("//a[@href='https://www.gittigidiyor.com/sepetim']"));

        miniBasketButton.click();



        String basketPrice = driver.findElement(By.cssSelector("div.total-price > strong")).getText();
        System.out.println("Sepet sayfasındaki fiyat = " + basketPrice);

        Assert.assertTrue("Ürün fiyatı ve Sepetteki ürün fiyatı eşit değil!",
                productPrice.equals(basketPrice));
        System.out.println("Ürün sayfasındaki fiyat ve sepetteki fiyat aynı.");


        Thread.sleep(10000);

        WebElement amountPicker = driver.findElement(By.cssSelector("select.amount"));

        amountPicker.click();

        WebElement addAmount = driver.findElement(By.cssSelector("select.amount > option:nth-child(2)"));

        addAmount.click();

        Thread.sleep(4000);

        WebElement deleteButton = driver.findElement(By.cssSelector("div.text-box a.btn-delete"));

        deleteButton.click();

        driver.quit();



    }


}



