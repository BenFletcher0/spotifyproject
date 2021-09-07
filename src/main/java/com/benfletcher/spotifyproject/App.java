package com.benfletcher.spotifyproject;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner kB = new Scanner(System.in);
        System.out.println("Type an album name here: ");
        String answerAlbum = kB.nextLine();
        System.out.println("Type the artist's name here: ");
        String answerArtist = kB.nextLine();

        HttpClient client = HttpClient.newHttpClient(); //https://www.baeldung.com/java-http-response-body-as-string
        // for help with HTTPclient
        HttpRequest request = HttpRequest.newBuilder()
                .uri(
                        URI.create(urlCreator(answerAlbum,answerArtist ))
                )
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body();
        Gson gson = new Gson();
        Outer outer = gson.fromJson(responseString, Outer.class);
        System.out.println(outer);


    }
    public static String urlCreator(String alb, String art){
        return "http://ws.audioscrobbler.com/2.0/?method=album.getinfo&" + API.API_KEY + "&artist=" + art.replace(" ", "%20") +"%20" +   "&album=" + alb.replace(" ", "%20") + "&format=json";

    }
}
