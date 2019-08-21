import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {
       
        // String DatasetFolder = "/media/bankapur/C4A400F4A400EAAE1/Research/NITK/Implementation/Objective2/Embeddings/GloVe";
        // String DestinationDatasetFolder =	"/media/bankapur/C4A400F4A400EAAE1/Research/NITK/Implementation/Objective2/Embeddings/W2V_SG";
        String DatasetFolder= "SCOPe_207";
        String DF_Name = "SCOPe_207";
        String DataFileName = DatasetFolder + "/"+DF_Name+".csv";
        
        String FeatureFileName = DatasetFolder + "/"+DF_Name+"_SeqCode_withthreshold.csv";
        // String FeatureFileName = DestinationDatasetFolder + "/"+DF_Name+"/"+DF_Name+".csv";

        ReadInputCSV RICSV = new ReadInputCSV();
        ArrayList<DataObject> inputData = new ArrayList<DataObject>();        
        inputData = RICSV.ReadData(DataFileName);
        
        StrSeqCode_Generation SSCG = new StrSeqCode_Generation();     
        inputData = SSCG.Process_Consecutive_HE_Counts(inputData);
        
        WriteOutputCSV WOCSV = new WriteOutputCSV();
        WOCSV.writeDataObject(FeatureFileName, inputData);
        
        System.out.println("Done!!!");
        
    }
}