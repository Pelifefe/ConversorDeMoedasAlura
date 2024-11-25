package http;

import java.net.URI;
import java.net.http.HttpRequest;

public class Request {

    public HttpRequest createRequest(String endereco, String apikey, String moedaBase, String moedaAlvo){
        String url = endereco + apikey + "/pair/" + moedaBase + "/" + moedaAlvo;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }
}
