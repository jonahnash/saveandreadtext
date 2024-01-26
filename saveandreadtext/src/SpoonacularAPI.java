import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.border.Border;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;

public class SpoonacularAPI {

    public String id;
    public String title;
    public String image;
    public String imageType;
    public int usedIngredientCount;
    public int missedIngredientCount;
    public ArrayList<Object> missedIngredients = new ArrayList<>();
    public ArrayList<Object> usedIngredients = new ArrayList<>();
    public ArrayList<Object> unusedIngredients = new ArrayList<>();
    public int likes;

    public JFrame f;
    public JTextField input, input2;
    public JTextField output, output2, output3;
    public JPanel centerPanel, rightPanel, inputPanel;
    public JButton enter, enter2, zero, one, two, three, four, five, six, seven, eight, nine;
    public static String[] meals = new String[10];
    static String moodInput = "";
    static String ingredientInput = "banana";
    static int chosenRecipe = 1;
    static String moodOutput = "";
    static String mealsOutput = "";
    static String descriptionOutput = "";
    public static void main(String[] args) throws ParseException {
        SpoonacularAPI myMain;
        myMain = new SpoonacularAPI();
        JSONObject file = new JSONObject();
        pullMood();
        pullSpoonacular();
        pullDescription();
        System.out.println("Congrats on finding a meal! Enjoy!");
    }
    public SpoonacularAPI(){
        graphics();
    }
    public void graphics(){
        f=new JFrame("Button Example");
        f.setLayout(new BorderLayout());
        centerPanel = new JPanel();
        rightPanel = new JPanel();
        inputPanel = new JPanel();
        input = new JTextField();
        input2 = new JTextField();
        output= new JTextField();
        output2 = new JTextField();
        output3 = new JTextField();
        enter = new JButton("ENTER1");
        enter2 = new JButton("ENTER2");
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                moodInput = input.getText();
                try {
                    pullMood();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                output.setText(moodOutput);
            }
        });
        enter2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingredientInput = input2.getText();
                try {
                    pullSpoonacular();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                output2.setText(mealsOutput);
            }
        });
        zero.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 0;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        one.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 1;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        two.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 2;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        three.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 3;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        four.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 4;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        five.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 5;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        six.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 6;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        seven.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 7;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        eight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 8;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });
        nine.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                chosenRecipe = 9;
                try{
                    pullDescription();
                }catch(ParseException ex){
                    throw new RuntimeException(ex);
                }
                output3.setText(descriptionOutput);
            }
        });


        inputPanel.setLayout(new GridLayout(2,1));
        f.add(rightPanel,BorderLayout.EAST);
        f.add(inputPanel,BorderLayout.NORTH);
        f.add(centerPanel,BorderLayout.CENTER);
        inputPanel.add(input);
        inputPanel.add(input2);
        centerPanel.setLayout(new GridLayout(3,1));
        centerPanel.add(output);
        centerPanel.add(output2);
        centerPanel.add(output3);
//        f.add(centerPanel,BorderLayout.CENTER);
        rightPanel.setLayout(new GridLayout(12,1));
        rightPanel.add(enter);
        rightPanel.add(enter2);
        rightPanel.add(zero);
        rightPanel.add(one);
        rightPanel.add(two);
        rightPanel.add(three);
        rightPanel.add(four);
        rightPanel.add(five);
        rightPanel.add(six);
        rightPanel.add(seven);
        rightPanel.add(eight);
        rightPanel.add(nine);
        f.setVisible(true);

    }
    public static void pullMood() throws ParseException{
        String apiKey = "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";
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter your mood");
        //String moodInput = scanner.next();
        String prompt = "10 edible ingredients for when in a " + moodInput + " mood (no description)";

        try {

            pullMood2(apiKey, prompt);
          //  System.out.println("ChatGPT Response:\n" + response);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void pullMood2(String apiKey, String prompt) throws ParseException{
        String output = "";
        String totalJson = "";
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");

            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Authorization", "Bearer " + apiKey);

            httpConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
            writer.write("{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [\n      {\n        \"role\": \"system\",\n        \"content\": \""+prompt+"\"\n      },\n      {\n        \"role\": \"user\",\n        \"content\": \"Hello!\"\n      }\n    ]\n  }");
            writer.flush();
            writer.close();
            httpConn.getOutputStream().close();

            if (httpConn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConn.getResponseCode());
            }
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            //System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                //System.out.println(output);
                totalJson+=output;
            }
            String line;
            String response = "";

            while ((line = reader.readLine()) != null) {
                response+=line;
            }
            // Close resources
            reader.close();
            httpConn.disconnect();

            // Process the response
            System.out.println(response.toString());
//            System.out.println("hello");

        }catch(IOException e){
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totalJson);
        try {
            //System.out.println(jsonObject);
            JSONArray choices = (JSONArray) jsonObject.get("choices");
            //System.out.println(choices);
            JSONObject ch = (JSONObject) choices.get(0);
            //System.out.println(ch);
            JSONObject message = (JSONObject) ch.get("message");
            String content = (String) message.get("content");
            System.out.println(content);
            moodOutput = content;

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void pullSpoonacular() throws ParseException{
        // Replace "YOUR_API_KEY" with your actual Spoonacular API key
        String apiKey = "ea993a825ccc40b6bfd5bbf04cd9a776";
        String apiUrl = "https://api.spoonacular.com/recipes/findByIngredients";
        String totalJson = "";
        String output = "";
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter your ingredients");
        //String ingredientInput = scanner.next();
        // Request parameters (customize based on your needs)
        String ingredients = ingredientInput;
        int number = 10;
        try {
            // Create URL
            URL url = new URL(apiUrl + "?apiKey=" + apiKey + "&ingredients=" + ingredients + "&number=" + number);
            //https://api.spoonacular.com/recipes/findByIngredients?apiKey=ea993a825ccc40b6bfd5bbf04cd9a776&ingredients=apple,banana&number=5

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());
            }
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                //System.out.println(output);
                totalJson+=output;
            }
            String line;
            String response = "";

            while ((line = reader.readLine()) != null) {
                response+=line;
            }
            // Close resources
            reader.close();
            connection.disconnect();

            // Process the response
            System.out.println(response.toString());
//            System.out.println("hello");

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) parser.parse(totalJson);
        try {
//            System.out.println(jsonArray);
            for(int n=0;n<number;n++) {
                org.json.simple.JSONObject jsonObject = (JSONObject) jsonArray.get(n);
//            System.out.println(jsonObject);

                String title = (String) jsonObject.get("title");
                System.out.println(n + ": " + title);
                meals[n] = (String)title;
                if(n<number-1) {
                    mealsOutput = mealsOutput + "" + n + ") " + meals[n] + ", ";
                }else{
                    mealsOutput = mealsOutput + "" + n + ") " +  meals[n] + ".";
                }
                long usedIngredients = (long) jsonObject.get("usedIngredientCount");
//            int usedIngredients= (int) usedIngredientsLong;
//            System.out.println("ingredients used: " + usedIngredients);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void pullDescription() throws ParseException{
        String apiKey = "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";
        String output = "";
        String totalJson = "";
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter your which recipe would you like to learn more about?");
        //int chosenRecipe = scanner.nextInt();
//        int cRInt = (chosenRecipe);
        System.out.println(meals[chosenRecipe]);
        String prompt = "Describe " + meals[chosenRecipe] + " in two sentences. The first sentence should include flavor facts and the second should include ingredients and nutrition facts.";
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");

            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Authorization", "Bearer " + apiKey);

            httpConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
            writer.write("{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [\n      {\n        \"role\": \"system\",\n        \"content\": \""+prompt+"\"\n      },\n      {\n        \"role\": \"user\",\n        \"content\": \"Hello!\"\n      }\n    ]\n  }");
            writer.flush();
            writer.close();
            httpConn.getOutputStream().close();

            if (httpConn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConn.getResponseCode());
            }
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            //System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                //System.out.println(output);
                totalJson+=output;
            }
            //System.out.println(totalJson);
            String line;
            String response = "";

            while ((line = reader.readLine()) != null) {
                response+=line;
            }
            // Close resources
            reader.close();
            httpConn.disconnect();

            //JSONParser parser = new JSONParser();
            //org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) parser.parse(totalJson);
            //org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totalJson);
            // Process the response
            //System.out.println(response.toString());
//            System.out.println("hello");

        }catch(IOException e){
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totalJson);
        try {
            //System.out.println(jsonObject);
            JSONArray choices = (JSONArray) jsonObject.get("choices");
            //System.out.println(choices);
            JSONObject ch = (JSONObject) choices.get(0);
            //System.out.println(ch);
            JSONObject message = (JSONObject) ch.get("message");
            String content = (String) message.get("content");
            System.out.println(content);
            descriptionOutput = content;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Do you like THIS recipe or would you like a NEW one?");
//        String decided = scanner.next();
//        if(decided.equals("THIS")) {
//            return;
//        }if(decided.equals("NEW")){
//            pullDescription();
//        }

    }
}
