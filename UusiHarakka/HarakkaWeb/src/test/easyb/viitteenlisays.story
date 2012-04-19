import harakka.*
import harakka.controller.*
import harakka.data_access.*
import harakka.domain.*
import harakka.service.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can create a reference'

serverAddress = "http://localhost:9090";

scenario "creation successful", {
    given 'command add a reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get(serverAddress);
 
    }
    when 'article data entered', {
        element = driver.findElement(By.name("tunnus"));
        element.sendKeys("123");
        element = driver.findElement(By.name("viitenimi"));
        element.sendKeys("Testi");
        element = driver.findElement(By.name("author"));
        element.sendKeys("TestiAuthoro");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Title");
        element = driver.findElement(By.name("vuosi"));
        element.sendKeys("1234");
        element = driver.findElement(By.name("lisaaInput"));
        element.submit();
        
    }
    then 'new reference has been registered to system', {
        driver.get(serverAddress)
        driver.getPageSource().contains("123").shouldBe true
    }
}
