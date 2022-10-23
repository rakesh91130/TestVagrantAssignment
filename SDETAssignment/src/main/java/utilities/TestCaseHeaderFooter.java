package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestCaseHeaderFooter extends ExtentReporting{
	
	public static ExtentTest startFrameworkReports() {
		String reportPath="Results/ExtentReports";
		try {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_YY");
			String sysDate = formatter.format(date);
			//extend logging file path setting
			
			File reportDir = new File("Results/ExtentReports");
			System.out.println(reportDir.toString());
			if(!reportDir.exists()) {
				boolean success = reportDir.mkdirs();
				System.out.println("create dir "+success);
			}
			System.out.println(reportPath+"//Extent_Report_"+sysDate+"_.html");
			extentReports = new ExtentReports(reportPath+"//Extent_Report_"+sysDate+"_.html", false);
			
			System.out.println("System.getProperty(\"user.dir\") "+System.getProperty("user.dir"));
			extentReports.loadConfig(new File(System.getProperty("user.dir")));
			extentReports.addSystemInfo("username","rakes kumar");
			extentReports.addSystemInfo("Company","TestVagrant");
			
			System.out.println(System.getProperty("module"));
			logger = extentReports.startTest(System.getProperty("module"));
			//return logger;
		} catch (Exception e) {
			//throw new FlexFrameworkRuntimeException(e);
			e.printStackTrace();
		}
		return logger;		
		
	}
	/***Method end extent reporting***/
	public void endFrameworkReports() {
		
		
		try {
			System.out.println(logger.getDescription());
			System.out.println(logger.getStartedTime().toString());
			System.out.println("project name "+extentReports.getProjectName());
			extentReports.endTest(logger);
			System.out.println("reached here");
			extentReports.flush();
			System.out.println("reached here1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
