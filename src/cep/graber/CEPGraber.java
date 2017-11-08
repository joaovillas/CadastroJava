package cep.graber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;






//throws MalformedURLException, IOException, ParseException

public class CEPGraber {

    public JSONObject pegaCep(String cep)throws MalformedURLException, IOException, ParseException{
        
       
        URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
        String inputLine;
        String aux= "" ;
        while((inputLine = in.readLine())!=null)
          aux += inputLine;
            
            
        in.close();
        jsonObject = (JSONObject) parser.parse(aux);
        
        
        return jsonObject;
           
    }

 
    
}
