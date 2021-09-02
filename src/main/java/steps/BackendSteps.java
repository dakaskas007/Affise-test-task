package steps;

import config.TestConfig;
import tools.DataGenerator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BackendSteps {
    public static final String API_KEY = TestConfig.getConfig().getKeys().getApiKey();

    public static String email = "";
    public static String password = "";

    public void addNewUser() throws IOException {
        email = DataGenerator.generateString(5) + "@" + DataGenerator.generateString(5) + ".com";
        password = DataGenerator.generateString(6);
        String urlParameters  = "email=" + email + "&password=" + password + "&last_name=Affise&first_name=User&roles[]=ROLE_ADMIN";
        byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int postDataLength = postData.length;
        String request = "https://api-preprod.affise.com/3.0/admin/user";
        URL url = new URL( request );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
        conn.setRequestProperty("API-Key", API_KEY);
        conn.setUseCaches(false);
        try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write( postData );
        }
        InputStream stream = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"), 8);
        reader.readLine();
    }
}