package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {
	WebDriver driver;
	public WikipediaPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(how=How.XPATH, using="//table[@class='infobox vevent']/tbody/tr[12]/td")
	@CacheLookup
	WebElement eleReleasedDate;

	@FindBy(how=How.XPATH, using="//table[@class='infobox vevent']/tbody/tr[14]/td")
	@CacheLookup
	WebElement eleCountry;

	public String getReleasedDateWiki() {
		return eleReleasedDate.getText();
	}

	public String getCountryWiki() {
		return eleCountry.getText();
	}


}
