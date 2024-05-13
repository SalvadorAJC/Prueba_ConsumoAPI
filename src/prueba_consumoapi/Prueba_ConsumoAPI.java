/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba_consumoapi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Salvador
 */
public class Prueba_ConsumoAPI {

    public static void main(String[] args) {
       try {
         URL url = new URL("https://jsonplaceholder.typicode.com/posts");
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.connect();
         
         int responseCode = conn.getResponseCode();
                 if (responseCode !=200){
                     throw new RuntimeException("Error" + responseCode);
                 } else {
                     StringBuilder informationString = new StringBuilder();
                     Scanner scanner = new Scanner(url.openStream());
                     
                     while (scanner.hasNext()){
                         informationString.append(scanner.nextLine());
                     }
                     
                     scanner.close();
                     
                     System.out.println(informationString);
                 }
       } catch (Exception e){
           e.printStackTrace();
       }
    }
    
}
