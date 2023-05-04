package application;


import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {

        Map<String, Integer> people = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br =  new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(", ");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if(people.containsKey(name)) {
                    int peopleSofar = people.get(name);
                    people.put(name, count + peopleSofar);
                }else{
                    people.put(name, count);
                }
                line = br.readLine();
            }

            for(String key : people.keySet()) {
                System.out.println(key + ": " + people.get(key));
            }

        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
     }
}
