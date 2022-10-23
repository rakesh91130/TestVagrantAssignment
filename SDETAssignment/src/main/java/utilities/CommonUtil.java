package utilities;

import com.relevantcodes.extentreports.LogStatus;

public class CommonUtil extends ExtentReporting {
	
	public void ValidationFor2Fields(String expectedString, String actualString, String identifier, String validation) {
		try {
			if(expectedString.trim().equals(actualString.trim())) {
				logger.log(LogStatus.PASS, validation+" Validation Passed : ", identifier+" : "+"<b>"+actualString+"</b> Validated succesfully");
			}
			else {
				logger.log(LogStatus.FAIL, validation+" Validation failed : ", identifier+" : "+"<b>"+actualString+"</b> not Matched with"+"<b>"+expectedString+"</b>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
