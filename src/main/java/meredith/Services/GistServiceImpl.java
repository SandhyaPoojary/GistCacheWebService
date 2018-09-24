package meredith.Services;

import meredith.Model.Gists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class GistServiceImpl implements GistService {

    private static String baseUrl;

    @Value("${baseUrl}")
    public void setBaseURL (String baseUrl){
        this.baseUrl = baseUrl;
    }


    @Override
    public Gists getGists(String id) {
        Gists getGists = null;
        HttpsURLConnection connection = null;

        try {
            connection = getConnection(id);
            String response = getResponse(connection);
            getGists = deserialize(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getGists;
    }

    //deserializing by contructing readTree from the response.
    private Gists deserialize(String response) {
        Gists gists = null;
        GistDeserializer gistDeserializer = new GistDeserializer();
        return gistDeserializer.deserialize(response);
    }

    private String getResponse(HttpsURLConnection connection) {
        StringBuilder response = new StringBuilder();

        try {
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line ;
            while((line = reader.readLine()) != null){
                response.append(line);
                response.append("\r");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    private HttpsURLConnection getConnection(String id) throws Exception {
        HttpsURLConnection connection = null;
        URL url = new URL(baseUrl + "gists" + "/" + id);
        connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        return connection;
    }
}
