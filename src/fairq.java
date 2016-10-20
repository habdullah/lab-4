import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class fairq {

	public static void main(String[] args) {

        String csvFile = "file.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Map<Integer, String[]> data = new HashMap<Integer, String[]>(); 
        //try start
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i =0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);

              //  System.out.println("row [start date= " + row[0] + " , end Date" + row[1] + " , Activity" + row[2] + "]");
                data.put(i, row);
                i=i+1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //try end
        //temp list to copy column 3 to
        List<String> temp1 = new ArrayList<String>();
        
        for (int j =0;j<data.size();j++){
        	String[] temp = data.get(j);
        	temp1.add(temp[2]);
        }
        //convet temp list to array
        String[] col3 = new String[ temp1.size() ];
        temp1.toArray( col3 );
        //temp set to find unique values in col3.convert set to string array
        Set<String> temp = new HashSet<String>(Arrays.asList(col3));
        String[] unique = temp.toArray(new String[temp.size()]);
        
        for (int k =0;k<unique.length;k++){
        	System.out.print(unique[k]+"\n");
        }
        
        
	}

}
