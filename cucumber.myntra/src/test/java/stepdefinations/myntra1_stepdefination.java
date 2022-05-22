package stepdefinations;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;


public class myntra1_stepdefination {
	
	WebDriver driver;

@Given("^myntra app$")
public void myntra_app() 
  {

	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
     driver.get("https://www.myntra.com/");
	 driver.manage().window().maximize();   
	 System.out.println("open myntra app");  
  }


@Then("^select item size$")
public void select_item_size()
  {
	   //go to men
	   Actions action = new Actions(driver);
	   WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
	   action.moveToElement(men).build().perform(); 
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   //go to item
	   WebElement tshirt= driver.findElement(By.xpath("//a[text()='T-Shirts']"));
	   action.moveToElement(tshirt).build().perform();
	   tshirt.click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
      // click on selected itom
	   driver.findElement(By.xpath("//a[@href=\"tshirts/hrx-by-hrithik-roshan"
		+ "/hrx-by-hrithik-roshan-men-yellow-printed-cotton-pure-cotton-t-shirt/1700944/buy\"]")).click();	
       System.out.println("select item");  
  }


@Then("^add to bag$")
public void add_to_bag() 
  {
	    Actions actions=new Actions(driver);
	    
	    //new tab open ,this is handle as
	    ArrayList<String> tab   = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tab.get(1));
	    
	    //choose size of item(t-shirt)
	    WebElement sizeM = driver.findElement(By.xpath("//p[text()='M']"));
	    actions.moveToElement(sizeM).build().perform();
	    sizeM.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //add to mybag  
	    driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")).click();
	    System.out.println("item added to my bag");
  }



@Then("^check item will add or not$")
public void check_item_will_add_or_not()
  {
	    ArrayList<String> tab   = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tab.get(1)); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //check the added item in mybag
        driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();	
        System.out.println("check item added im my bag");       
  }



@And("^Closebrowser$")
public void closebrowser() 
  {
       ArrayList<String> tab   = new ArrayList<String>(driver.getWindowHandles());
       driver.switchTo().window(tab.get(1)); 
       driver.close();
       driver.switchTo().window(tab.get(0)); 
       driver.close();
       System.out.println("close the the browser after test comleted");
  }
 
}
