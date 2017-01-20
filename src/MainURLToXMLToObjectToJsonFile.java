import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 33558 on 19.01.2017.
 */
public class MainURLToXMLToObjectToJsonFile {
    public static void main(String[] args) {
        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";
        String pathName = "URLObject.xml";
        Query query = null;
        Gson gson = new GsonBuilder().create();
        File file = new File(pathName);

        String xmlQuery = performRequest(request);
        query = getQuery(query, file);
        writeToFile(xmlQuery, pathName);
        String jsonQuery =  gson.toJson(query);
        writeToFile(jsonQuery, "json.json");

        System.out.println(query.toString());
        System.out.println(jsonQuery.toString());
    }

    private static Query getQuery(Query query, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            query = (Query) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return query;
    }

    private static void writeToFile(String result, String pathname) {
        PrintWriter out = null;
        try {
            out = new PrintWriter( new File(pathname) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println( result );
        out.close();
    }

    private static String performRequest(String request) {
        URL url;
        StringBuilder sb = new StringBuilder();
        HttpURLConnection http = null;

        try {
            url = new URL(request);
            http = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            http.disconnect();
        }
        return sb.toString();
    }
}
