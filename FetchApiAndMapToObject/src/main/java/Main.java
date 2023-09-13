import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://randomuser.me/api/1.4/");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() == 200) {
            StringBuilder sb = new StringBuilder();
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }

            sc.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);
            JsonObject results = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject();

            Person person = gson.fromJson(results, Person.class);

            String jsonFromPerson = gson.toJson(person);
            System.out.println(jsonFromPerson);

            String resultToString = results.toString();
            System.out.println(resultToString);

//            check objects
            System.out.println(Objects.equals(jsonFromPerson, resultToString));


            System.out.println(person.getName().getFirst());
            System.out.println(person.getLocation().getStreet().getName());


        }
    }
}
