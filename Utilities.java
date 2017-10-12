import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Utilities{

    final static String SEVEN_MAP = "input77.txt";
    final static String EIGHT_MAP = "input88.txt";
    final static String NINE_MAP = "input99.txt";

  public static void fileReader(){

    BufferedReader reader = null;
    BufferedReader next_reader = null;
    try {
        File file = new File(SEVEN_MAP);
        reader = new BufferedReader(new FileReader(file));
        String line;
       
        //detector for next line equals null
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
          
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }

}