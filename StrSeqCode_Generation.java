import java.util.ArrayList;

public class StrSeqCode_Generation {
	
		
	public ArrayList<DataObject> Process_Consecutive_HE_Counts(ArrayList<DataObject> inputData) {
		ArrayList<DataObject> processedInputData = new ArrayList<DataObject>();
				
				for(int i=0; i<inputData.size(); i++) {
					DataObject data = inputData.get(i);
					data.ProteinStr_HE = data.ProteinStr.toString().replace("C","");
					// data.ProteinStr_HE = data.ProteinStr.toString();
					data.ProteinStrCode = Consecutive_HE_Counts(data.ProteinStr_HE);					
					
					processedInputData.add(data);
				}
				return processedInputData;				
	}
	
	public String Consecutive_HE_Counts(String seq) {
		String Cons_HE_Count = "";		
		char prev = 0;
		char curr = 0;
		int count = 1;
		int threshold=10;
		for(int i=0; i<seq.length(); i++) {			
			curr = seq.charAt(i);
			if(i!=0){
				if(prev == curr)
					count++;
				else {
					if(count>=threshold){
					Cons_HE_Count += count+":"+prev+"--";}
					count = 1;
					// Cons_HE_Count += count+":"+prev+"--";
					// count = 1;
				}	
			}			
			prev = curr;			
		}
		if(count>=threshold){
		Cons_HE_Count += count+":"+prev;}
		if(Cons_HE_Count==""){
			Cons_HE_Count="X";

		}
		// Cons_HE_Count += count+":"+prev;
		return Cons_HE_Count;
	}
}