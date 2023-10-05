package scraping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Scraping {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://pulpfiction.dk/");
        InputStreamReader r = new InputStreamReader(url.openStream());
        BufferedReader in = new BufferedReader(r);
        String str;

        while ((str = in.readLine()) != null) {

                        System.out.println(str);

        }

        in.close();
    }
}
