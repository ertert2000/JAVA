package intrernet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;


public class internet {
    
    public static void main(String[] args)
    {
        URL yahoo = new URL("http://www.yahoo.com/");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
