package data_driven;

import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileDataTest {

    private static Map<String, String> dataMap = new HashMap<String, String>();

    private static void fileReader(){
        File file = new File("resources/login Data.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i == 0)
                    dataMap.put("username", line);
                else if (i == 1)
                    dataMap.put("password", line);
                else if (i==2)
                    dataMap.put("id",line);
                i++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        fileReader();
        System.out.println(dataMap.get("username"));
        System.out.println(dataMap.get("password"));
        System.out.println(dataMap.get("id"));
    }
}
