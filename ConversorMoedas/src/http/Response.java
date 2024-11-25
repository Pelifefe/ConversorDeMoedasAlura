package http;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Response {
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private String moedaBase;
    private String moedaAlvo;
    private final String APIKEY = "c29e82963777cf3e5173c963";

    public Response(String moedaBase, String moedaAlvo){
        this.moedaBase = moedaBase;
        this.moedaAlvo = moedaAlvo;
    }

    public String getResponse() throws IOException, InterruptedException {
        Request request = new Request();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request.createRequest(this.ENDERECO, this.APIKEY, this.moedaBase, this.moedaAlvo),
                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
