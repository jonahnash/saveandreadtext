import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
public class Hero {
    public String name;
    public int height;
    public int mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public ArrayList<String> films = new ArrayList<String>();
    public String species;
    public ArrayList<String> vehicles = new ArrayList<String>();
    public ArrayList<String> starships = new ArrayList<String>();
    public String created;
    public String edited;
    public String url;
    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.

        JSONObject file = new JSONObject();


        // To print in JSON format.
        pull();
    }

    public static void pull() throws ParseException {
        String output = "abc";
        String totlaJson="";
        try {

            URL url = new URL("https://swapi.dev/api/people/4/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                totlaJson+=output;
            }
            conn.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totlaJson);
        System.out.println(jsonObject);

        try {

            String name= (String)jsonObject.get("name");
            System.out.println("name: " + name);

            String height= (String) jsonObject.get("height");
            System.out.println("height: " + height);

            String mass= (String)jsonObject.get("mass");
            System.out.println("mass: " + mass);


            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("films");
            int n =   msg.size(); //(msg).length();
            for (int i = 0; i < n; ++i) {
                String test =(String) msg.get(i);
                System.out.println(test);
                // System.out.println(person.getInt("key"));
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }




    }
}