import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");

        WebDriver wd = new ChromeDriver();
        wd.get("https://7745.by/");
        WebElement input = wd.findElement(By.id("search"));
        input.sendKeys("zal oopa");
        WebElement searchBtn = wd.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/form/button"));
        searchBtn.click();
        Thread.sleep(2);
        wd.quit();
    }
}
