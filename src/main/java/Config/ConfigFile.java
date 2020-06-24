package Config;

public class ConfigFile {
	
	public static String  currentDirectory=System.getProperty("user.dir");
	public static  String reportConfigPath=currentDirectory +"\\extent-config.xml";
	
	public static  String outPutDir=currentDirectory+"\\ScreenShot\\OutputTestJustEat.html";

	public static  String screenShot=currentDirectory+"\\ScreenShot";
	
	public String getReportConfigPath(){
		
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
			
}
