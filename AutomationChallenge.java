package locating.elements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AutomationChallenge {
    WebDriver driver;
    //METHOD FOR THE FINAL TEST
    public String cellFinder(int rowNum, int colNum) {
        //To locate table.
        WebElement table = driver.findElement(By.tagName("tbody"));
        //To locate rows of table.
        List < WebElement > rows_table = table.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        String cell = "not found";
        //Loop will execute for all the rows of the table
        for (int row = 0; row < rows_count; row++) {

            //To locate columns(cells) of that specific row.
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

            //To calculate no of columns(cells) In that specific row.
            int columns_count = Columns_row.size();

            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                //To retrieve text from the cells.
                String celltext = Columns_row.get(column).getText();
                if(row == rowNum && column == colNum){
                    cell = "Cell Value of row number " + row + " and column number " + column + " Is " + celltext;
                }
            }
        }
        return cell;
    }

    @Before
        public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
        public void test1(){
        //Navigate to the file???? not sure whats meant here
        driver.get("https://jesse-rocha.github.io/AutomationChallenge/");
        //locate the email and password inputs
        WebElement email = driver.findElement(By.xpath("//div[@id=\"test-1-div\"]//form[@class=\"form-signin\"]//input[@type=\"email\"]"));
        WebElement password = driver.findElement(By.xpath("//div[@id=\"test-1-div\"]//form[@class=\"form-signin\"]//input[@type=\"password\"]"));
        WebElement button = driver.findElement(By.xpath("//div[@id=\"test-1-div\"]//form[@class=\"form-signin\"]//button[@type=\"submit\"]"));
        //assert that both the email and password are visible.
        Assert.assertTrue(email.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
        Assert.assertTrue(button.isDisplayed());
        //enter the email address and password //with a form you can use the submit
        email.click();
        email.sendKeys("email@gmail.ca");
        password.click();
        password.sendKeys("notapassword");
        //submit button
        button.click();
        }

    @Test
    public void test2(){
        //Navigate to the file???? not sure whats meant here
        driver.get("https://jesse-rocha.github.io/AutomationChallenge/");
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id=\"test-2-div\"]//ul[@class=\"list-group\"]//li[@class=\"list-group-item justify-content-between\"]"));
        //assert that there are three values in the list group
        Assert.assertEquals(3,rows.size());
        //assert that the 2nd item is List Item 2 I THINK IM DOING THIS WRONG
        WebElement item2 = driver.findElement(By.xpath("//div[@id=\"test-2-div\"]//ul[@class=\"list-group\"]//li[contains(text(),'List Item 2')]"));
        String text = item2.getText();
        Assert.assertTrue(text.contains("List Item 2"));
        //Assert that the second list item's badge value is 6
        WebElement badge = driver.findElement(By.xpath("//div[@id=\"test-2-div\"]//ul[@class=\"list-group\"]//li[contains(text(),'List Item 2')]//span"));
        String badgetext = item2.getText();
        Assert.assertTrue(badgetext.contains("6"));
    }

    @Test
    public void test3(){
        //Navigate to the home page
        driver.get("https://jesse-rocha.github.io/AutomationChallenge/");
        //In the test 3 div, assert that "Option 1" is the default selected value
        WebElement Option1 = driver.findElement(By.xpath("//div[@id=\"test-3-div\"]//div[@class=\"dropdown\"]//button[@id=\"dropdownMenuButton\"]"));
        var text = Option1.getText();
        Assert.assertEquals("Option 1",text);//assert that the text is in the drop down
        //Select "Option 3" from the select list
        //find the dropdown and click
        WebElement dropdown = driver.findElement(By.xpath("//div[@id=\"test-3-div\"]//div[@class=\"dropdown\"]//button[@id=\"dropdownMenuButton\"]"));
        dropdown.click();
        //find the option 3 and click it
        WebElement Option3 =  driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));
        Option3.click();
    }

    @Test
    public void test4(){
        //Navigate to home page
        driver.get("https://jesse-rocha.github.io/AutomationChallenge/");
        //In the test 4 div,
        //assert that the first button is enabled
        WebElement button1 = driver.findElement(By.xpath("//div[@id=\"test-4-div\"]//button[@class=\"btn btn-lg btn-primary\"]"));
        Assert.assertTrue(button1.isEnabled());
        //and that the second button is disabled
        WebElement button2 = driver.findElement(By.xpath("//div[@id=\"test-4-div\"]//button[@class=\"btn btn-lg btn-secondary\"]"));
        Assert.assertFalse(button2.isEnabled());
    }
    @Test
    public void test5(){
        //Navigate to home page
        driver.get("https://jesse-rocha.github.io/AutomationChallenge/");
        //In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
        //use explicit wait whichever it is that waits until said element will appear.
        //Once you've clicked the button, assert that a success message is displayed
        WebDriverWait wait = new WebDriverWait (driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"test-5-div\"]//button[@id=\"test5-button\"]")));

        WebElement button = driver.findElement(By.xpath("//div[@id=\"test-5-div\"]//button[@id=\"test5-button\"]"));
        button.click();
        //WebDriverWait wait = new WebDriverWait(WebDriverReference,TimeOut);
        WebElement alert = driver.findElement(By.xpath("//div[@id=\"test-5-div\"]//div[@id=\"test5-alert\"]"));
        String text = alert.getText();
        Assert.assertTrue(text.contains("You clicked a button!")); // assert that the element contains the message
        //Assert that the button is now disabled
        Assert.assertFalse(button.isEnabled());
    }
    @Test
    public void test6(){
        //Navigate to home page
        driver.get("https://jesse-rocha.github.io/AutomationChallenge/");
        //Write a method that allows you to find the value of any cell on the grid

        //Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
        String toBeFound = cellFinder(2,2);
        //Assert that the value of the cell is "Ventosanzap"
        Assert.assertTrue(toBeFound.contains("Ventosanzap"));

    }
    @After
    public void tearDown(){
        //7. quit the device
        driver.quit();
    }

}
