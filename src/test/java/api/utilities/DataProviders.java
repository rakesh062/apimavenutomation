package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{

		XLUtilityFile xl=new XLUtilityFile(path);
		
		int rowNum=xl.getRowCount("Sheet1");
		int coloumnCount=xl.getColoumnCount("Sheet1", 1);
		
		String apidata[][]=new String[rowNum][coloumnCount];
		
		for(int i=1;i<=rowNum;i++) {
			
			for(int j=0;j<coloumnCount;j++) {
				
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		
		return apidata;
	}
	
	@DataProvider(name="Usernames")
	public String[] getUserNames() throws IOException {
		
		XLUtilityFile xl=new XLUtilityFile(path);
		
		int rowNum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rowNum];
		
		for(int i=1;i<=rowNum;i++) {
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
			
		}
		
		return apidata;
		
	}

}
