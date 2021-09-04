package com.benfletcher.spotifyproject;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(
                        URI.create(
                                "http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=" +
                                        API.API_KEY +
                                        "&artist=Cher&album=Believe&format=json"
                        )
                )
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body();
        Gson gson = new Gson();
        Outer outer = gson.fromJson(responseString, Outer.class);
        System.out.println(outer);


    }
}
