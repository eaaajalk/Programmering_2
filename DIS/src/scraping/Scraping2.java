package scraping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;

public class Scraping2 {
        public static void main(String[] args) throws IOException {
            URL url = new URL("https://m.valutakurser.dk");
            InputStreamReader r = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(r);
            String str;

            char tegn = '"';

            String target = "\"Amerikanske dollar\",\"symbol\":\"USD\",\"flagName\":\"USD\",\"currencyChange\":";

            while ((str = in.readLine()) != null) {
                if (str.contains(target)) {
                    String[] arr = str.split("\"USD\",\"currencyChange");
                        if (arr[1].contains("actualValue")) {
                            if (arr[1].contains("USD")) {
                                int h = arr[1].indexOf("actualValue");
                                System.out.println(arr[1].substring(h+13, h+19));
                            }

                        }

                }
            }
            in.close();
        }
    }






