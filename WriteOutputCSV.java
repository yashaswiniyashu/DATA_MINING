import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteOutputCSV {
	
	BufferedWriter bw = null;
	public void writeDataObject(String fName, ArrayList<DataObject> inputData) {
		
		try {
	    	
			File fileName = new File(fName);

			// if file doesn't exists, then create it
			if (!fileName.exists()) {
				fileName.createNewFile();
			}
			
			FileWriter fw = new FileWriter(fileName.getAbsoluteFile(),true);
			bw = new BufferedWriter(fw);
			String rowData = "";
			rowData = "PDBid,Sequence,Seq-Code,Class,Str-Code";
			bw.write(rowData+"\n");
			bw.flush();
			
			for(int i=0; i<inputData.size(); i++){
				rowData = "";
				DataObject DO = inputData.get(i);
				
				rowData = rowData+DO.ProteinID+",";
				rowData = rowData+DO.ProteinSeq+",";
				rowData = rowData+DO.ProteinStr+",";
				rowData = rowData+DO.Class+",";
				rowData = rowData+DO.ProteinStrCode;					
				bw.write(rowData+"\n");
				bw.flush();
			}			          	
	    }
	    catch (Exception e) {
			System.out.println("Error in Writing data !!!");
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();	
			}
			catch (IOException e) {
				System.out.println("Error while closing Writing data fileWriter !!!");
				e.printStackTrace();
			}
		}
	}

}
