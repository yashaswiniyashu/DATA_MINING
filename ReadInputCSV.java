import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadInputCSV {
	
	public ArrayList<DataObject> ReadData(String fileName) {

		ArrayList<DataObject> inputData = new ArrayList<DataObject>();		
		BufferedReader fileReader = null;
		int j=0;
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(fileName));
			
			while((line = fileReader.readLine()) != null){ 
				if(j++ != 0) {
					String[] tokens = line.split(",");
					if (tokens.length > 0) {
						DataObject DO = new DataObject();
						DO.ProteinID = tokens[0].toString();
						DO.ProteinSeq = tokens[1].toUpperCase().toString();
						DO.ProteinStr = tokens[2].toString();
						DO.Class = tokens[3].toString();
						
						
						inputData.add(DO);
					}
				}
			}

		}
		catch (Exception e) {
			System.out.println("Error in Loading data file!!!");
			e.printStackTrace();
		}
		finally {
			try {
				 fileReader.close();
			}
			catch (IOException e) {
				System.out.println("Error while closing data fileReader !!!");
				e.printStackTrace();
			}
		}		
		
		return inputData;
				
	}

}
