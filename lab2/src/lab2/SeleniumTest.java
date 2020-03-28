package lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String testID;
    private String gitHubUrl;


    public SeleniumTest(String testID, String githubUrl) {
        this.testID = testID;
        this.gitHubUrl = githubUrl;
    }

    @Before
    public void setUp() throws Exception {
    	String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        Object[][] obj = new Object[20][];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E://大三下资料//软件测试//实验2//test.csv"));
            //reader.readLine();
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                String stuID = item[0];
                String githubUrl = item[1];
                obj[count] = new Object[]{stuID, githubUrl};
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(obj);
    }

    @Test
    public void testMain() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("user_number")).clear();
        driver.findElement(By.name("user_number")).sendKeys(testID);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(gitHubUrl);
        driver.findElement(By.cssSelector("[type ='submit']")).click();
        assertEquals(this.gitHubUrl, driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code")).getText());
        //上面这个xpath有坑滴 不是div【4】
        driver.close();
    }

}

