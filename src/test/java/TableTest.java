import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {


    WebDriver wd;

    @BeforeMethod
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        //wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void tableTestCss() {
        WebElement canada = wd.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        //wd.findElement(By.xpath("//tr[8]/td[last()]"));
        String text = canada.getText();

        System.out.println(text);

        Assert.assertEquals(text, "Canada");
        Assert.assertTrue(text.contains("Can"));

    }

    @Test
    public void tableHomeWork() {
        //get row 4
        WebElement el = wd.findElement(By.cssSelector("tr:nth-child(4)"));
        //wd.findElement(By.xpath("//tr[4]"));
        String text = el.getText();
        System.out.println(text);
        Assert.assertEquals(text, "Centro comercial Moctezuma Francisco Chang Mexico");
        Assert.assertTrue(text.contains("Francisco Chang"));

        String text2 = wd.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(2)")).getText();
        // wd.findElement(By.xpath("//tr[4]//td[2]"));
        Assert.assertEquals(text2, "Francisco Chang");
        Assert.assertEquals(wd.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(2)")).getText(), "Francisco Chang");

        //Francisco Chang
        // Assert Francisco Chang?
    }

    @Test
    public void tableHW2() {
        //print numbers of rows

        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        //wd.findElements(By.xpath("//tr"));
        System.out.println(rows.size());
        Assert.assertEquals(rows.size(), 9);

        //print numbers of columns
        List<WebElement> columns = wd.findElements(By.cssSelector("tr th"));
        //wd.findElements(By.xpath("//tr/th"));
        System.out.println("Print numbers of last columns -->" + columns.size());
        System.out.println("*************************");

        //print rows 3
        List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3) td"));
        //wd.findElements(By.xpath("//tr[3]//td"));
        System.out.println("Row 3 --->" + row3.size());

        for (WebElement el : row3) {
            System.out.println(el.getText());
        }
        for (int i = 0; i < row3.size(); i++) {
            System.out.println(rows.get(i).getText());
        }

        //print lastColumns

        List<WebElement> lastColumns = wd.findElements(By.cssSelector("td:last-child"));
        //wd.findElements(By.xpath("//td[last()]"));
        for (WebElement el :
                lastColumns) {
            System.out.println(el.getText());
        }

        //print Maria Anders
        System.out.println(wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText());
        //wd.findElement(By.xpath("//tr[2]//td[2]"));
        //wd.findElement(By.xpath("//td[text()='Maria Anders']"));
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    @Test
    public void tableHw2() {

    }

}
