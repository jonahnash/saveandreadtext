import java.net.*;
import java.io.*;

public class HtmlRead {
   // String link = "https://en.wikipedia.org/wiki/Tom_Cruise";
    boolean found = false;
    String endLink = "https://en.wikipedia.org/wiki/Ice_hockey";//"https://en.wikipedia.org/wiki/Calgary_Flames";
    public static void main(String[] args) {
        HtmlRead Reader;
        Reader = new HtmlRead();
    }
        public HtmlRead(){
        String startLink = "https://en.wikipedia.org/wiki/Juuse_Saros";
        linkRecursion(startLink, 0);

//            try{
//                System.out.println();
//                URL url = new URL("https://www.milton.edu/");
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(url.openStream()));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    if(line.contains("href")){
//                        int startOfLink;
//                        int endOfLink;
//                        startOfLink = line.indexOf("href=") + 6;
//                        String startToEnd = line.substring(startOfLink);
//                        endOfLink = 0;
//                        if(startToEnd.contains("'")){
//                            endOfLink = line.indexOf("'",startOfLink);
//                        }if(startToEnd.contains("\"")){
//                            endOfLink = line.indexOf("\"",startOfLink);
//                        }
//                        //3System.out.println(line);
//                        System.out.println(line.substring(startOfLink,endOfLink));
//                    }
//            }
//                reader.close();
//            }catch(Exception ex){
//            System.out.println(ex);
//        }
    }
    public void linkRecursion(String myUrl, int counter){
        if(found == true){
            System.out.println("found end link in " + counter + "!");
            return;
        }else if(counter>2){
            System.out.println("max depth");
            return;
        }else{
            try{
                System.out.println();
                URL url = new URL(myUrl);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(url.openStream()));
                String line;
                while ((line = reader.readLine()) != null && found == false) {
                    if(line.contains("href")){
                        int start;
                        int end;
                        start = line.indexOf("href=") + 6;
                        String link = line.substring(start);
                        end = 0;
                        if(link.contains("'")){
                            end = line.indexOf("'",start);
                            link = line.substring(start,end);
                        }if(link.contains("\"")){
                            end = line.indexOf("\"",start);
                            link = line.substring(start,end);
                        }
                        if(!line.substring(start,end).contains("wikipedia.org") && !line.substring(start,end).contains("https")){
                            //System.out.println(line);
                            link = "https://en.wikipedia.org" + line.substring(start,end);
                        }if(link.contains("wikipedia.org") && !link.contains("https:")){
                            link = "https:" + link;
                        }

                       // System.out.println(link + "    " +myUrl + " " + end);
                        if(link.contains("wikipedia.org/wiki") && !link.substring(link.indexOf("wiki/")).equals(myUrl.substring(myUrl.indexOf("wiki/")))){
                            if(myUrl.equals(endLink)){
                                found = true;
                                System.out.println("found end link in " + (counter-1) + "! in while loop");
                                return;
                            }
                            System.out.println(link);
                            System.out.println(counter);
                            //System.out.println("test");
                            linkRecursion(link, counter + 1);
                        }
                    }
                }

                reader.close();
            }catch(Exception ex){
                System.out.println(ex);

            }
        }
    }



}
