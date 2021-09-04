package com.benfletcher.spotifyproject;

public class Outer {
    private Album album;
    public String toString(){
        return album.toString();
    }
    public class Album {
        private String artist;
        private int listeners;
        private String name;
        private int playcount;


        public String toString() {

            return "" + artist;
        }
    }
}