package Tatoc.Tatoc;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class basic 
{
    public static void main( String[] args )  throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\garimagupta\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	//  Wait For Page To Load
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	// Navigate to URL
    	driver.get("http://10.0.1.86/tatoc");
    	
    	//Comparing color of the Boxes
    	driver.findElement(By.xpath("//a[contains(text(),\"Basic Course\")] ")).click();
    	driver.findElement(By.xpath("//div[@class=\"greenbox\"]")).click();
    	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"main\"]")));
		String colorBox1=driver.findElement(By.xpath("//div[contains(text(),\"Box 1\")] ")).getAttribute("class");
    	System.out.print(colorBox1);
    	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"child\"]")));
    	System.out.println("Switching to iframe");
    	String colorBox2=driver.findElement(By.xpath("//div[contains(text(),\"Box 2\")]")).getAttribute("class");
    	System.out.print(colorBox2);
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"main\"]")));
    	while(!colorBox1.equalsIgnoreCase(colorBox2)) {
    	driver.findElement(By.xpath("//a[contains(text(),\"Repaint Box 2\")]")).click();
    	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"child\"]")));
    	colorBox2=driver.findElement(By.xpath("//div[contains(text(),\"Box 2\")]")).getAttribute("class");
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"main\"]")));
    	   }
    	driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]")).click();
    	
    	//Drag DropBox
        WebElement From=driver.findElement(By.xpath("//div[contains(text(),\"DRAG ME\")]"));	
    	WebElement To=driver.findElement(By.xpath("//div[contains(text(),\"DROPBOX\")]"));
        Actions act=new Actions(driver);	
        act.dragAndDrop(From, To).build().perform();	
        driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]")).click();
        
        //Launch PopUp Window
        String name="abc";
        driver.findElement(By.xpath("//a[contains(text(),\"Launch Popup Window\")]")).click();
        
        driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(name);
        driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
      }

    }
