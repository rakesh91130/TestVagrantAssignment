package testcases;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.ImdbPage;
import pageobject.WikipediaPage;
import utilities.CommonUtil;
import utilities.DateFormatter;
import utilities.ReadPropertiesFile;
import utilities.TestCaseHeaderFooter;

public class MovieInfoValidation extends BaseClass{
	CommonUtil util = new CommonUtil();
	static Properties pro = ReadPropertiesFile.readProperties();
	static final String  DATE_PATTERN ="MM-dd-yyyy";
	String releaseDateImdb;
	String countryImdb;
	String releaseDateWiki;
	String countryWiki;
static TestCaseHeaderFooter testCaseHeaderFooter = new TestCaseHeaderFooter();
	
	@Test
	public void movieInfoValidation() throws URISyntaxException {
		/*************IMDB relaese date and country retrieving****************/
		try {
			System.setProperty("module","<br>"+this.getClass().getSimpleName());
			testCaseHeaderFooter.startFrameworkReports();
			
			String imdbUrl = pro.getProperty("imdbUrl");
			System.out.println("imdbUrl "+imdbUrl );
			driver.get(imdbUrl);
			ImdbPage imdb = PageFactory.initElements(driver, ImdbPage.class);

			releaseDateImdb = imdb.getReleasedDate();
			releaseDateImdb = formateImdbReleaseDate(releaseDateImdb);
			releaseDateImdb = DateFormatter.formateDate(DATE_PATTERN, releaseDateImdb);
			
			System.out.println("releaseDateImdb "+releaseDateImdb);
			
			countryImdb = imdb.getCountry();
			System.out.println("imdb "+imdb);
			
			
			/*************Wikipedia relaese date and country retrieving****************/
			
			String wikiUrl = pro.getProperty("wikiUrl");
			System.out.println("wikiUrl "+wikiUrl);
			
			driver.get(wikiUrl);
			WikipediaPage wiki =  new WikipediaPage(driver);
			
			releaseDateWiki = wiki.getReleasedDateWiki();
			releaseDateWiki = DateFormatter.formateDate(DATE_PATTERN, releaseDateWiki);
			System.out.println("releaseDateWiki "+releaseDateWiki);
			
			countryWiki = wiki.getCountryWiki();
			System.out.println("countryWiki "+countryWiki);
			
			util.ValidationFor2Fields(countryWiki+"ra", countryImdb, "Country", "Wikipedia and IMDB");
			util.ValidationFor2Fields(releaseDateWiki, releaseDateImdb, "Released date", "Wikipedia and IMDB");
			
			//Assert.assertEquals(countryWiki, countryImdb);
			//Assert.assertEquals(releaseDateWiki, releaseDateImdb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			testCaseHeaderFooter.endFrameworkReports();
		}
		
		
		
		
		
		
		
		

	}

	private String formateImdbReleaseDate(String releaseDate2) {

		StringBuilder sb= new StringBuilder();
		sb.append(releaseDate2);
		System.out.println(sb.indexOf("("));
		int i=sb.indexOf("(");
		String formattedReleaseDate = releaseDate2.substring(0, i);		

		return formattedReleaseDate;
	}

}
