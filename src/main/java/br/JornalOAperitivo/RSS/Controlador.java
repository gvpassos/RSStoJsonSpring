package br.JornalOAperitivo.RSS;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    private ArrayList<Noticias> ListadNoticias = new ArrayList<Noticias>();

    @GetMapping(value = "/teste")
    public String testadora() {
        return "funcionando";
    }

    @GetMapping(value = "/Noticias")
    public String noticias() {
        // web conect
        URI uri = URI.create("https://www.jornaloaperitivo.com.br/feeds/posts/default");

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                uri)
                .header("CONTENT_LANGUAGE", "xml")
                .build();

        // use the client to send the request
        try {
            var response = client.send(request, BodyHandlers.ofString());
            String[] lista = response.body().split("<entry>");
            String Aux = "[";
            for (int c = 1; c < lista.length; c++) {
                System.out.println(c);
                Noticias noti = new Noticias(lista[c]);
                ListadNoticias.add(noti);
                Aux += noti.json() + ",";
            }
            Aux += "]";
            return Aux;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "hoje nao";
    }

}
