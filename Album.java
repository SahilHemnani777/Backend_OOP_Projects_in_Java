package com.hemnanisahil;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private ArrayList<Song> album;
    private String name;

    public boolean addSong(String song, int duration) {
        if(findSong(song)==null){
            album.add(new Song(song, duration));
            return true;
        }
        return false;
    }

    public Album(String name) {
        this.album = new ArrayList<Song>();
        this.name = name;
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }


    public Song findSong(String name){
        for (Song checkedSong: this.album){         //this is same as we do in python for i in list
            if (checkedSong.getSongTitle().equals(name)){
                return checkedSong;
            }
        }

        return null;
    }

    public boolean AddToPlaylist(int trackNumber , LinkedList<Song> playlist){
        int index =trackNumber-1;
        if (index>=0 && index<=this.album.size()){
            playlist.add(album.get(index));
            return true;
        }else {
            System.out.println("This album does not have "+album.get(index)+" song ");
            return false;
        }
    }

    public boolean AddToPlaylist(String songName, LinkedList<Song> playlist){
        if (findSong(songName)!=null){
            playlist.add(findSong(songName));
            return true;
        }else {
            System.out.println("This album does not have "+ songName+" song ");
            return false;
        }
    }
}
