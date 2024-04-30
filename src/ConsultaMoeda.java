import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {


    public Moeda buscaMoeda(String do_Codigo) {

        String Sua_Chave_Api = "";

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + Sua_Chave_Api + "/latest/" + do_Codigo);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson() .fromJson(response.body(), Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível conseguir achar essa moeda !!");
        }
    }
}