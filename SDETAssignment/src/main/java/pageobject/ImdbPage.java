package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ImdbPage {
	WebDriver driver;
	public ImdbPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sc-f65f65be-0 ktSkVi']/ul/li[1]/div")
	@CacheLookup
	WebElement eleReleasedDate;

	@FindBy(xpath="//div[@class='sc-f65f65be-0 ktSkVi']/ul/li[2]/div")
	@CacheLookup
	WebElement eleCountry;


	public String getReleasedDate() {
		return 	eleReleasedDate.getText();
	}

	public String getCountry() {
		return eleCountry.getText();
	}



}
