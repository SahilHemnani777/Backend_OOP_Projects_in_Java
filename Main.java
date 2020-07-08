package com.hemnanisahil;

import com.sun.jdi.VMCannotBeModifiedException;

import java.util.*;

public class Main {
    private static Scanner scanner=new Scanner(System.in);

    private static ArrayList<Album> albums=new ArrayList<Album>();
    public static void main(String[] args) {
        ////////////////////////////AASHQUI-2/////////////////////////////////////////

        Album aashiqui2 =new Album("Aashiqui 2");

        aashiqui2.addSong("Tum hi ho",360);
        aashiqui2.addSong("Milne hai mujhse aayi",243);
        aashiqui2.addSong("Bhula dena", 343);
        aashiqui2.addSong("Aashqui",200);
        aashiqui2.addSong("Sun raha hai na tu",343);
        aashiqui2.addSong("Chahun mai ya na",400);
        aashiqui2.addSong("Hum mar jayenge",488);
        albums.add(aashiqui2);
        /////////////////////////////////////KESARI//////////////////////////////////

        Album kesari =new Album("Kesari");

        kesari.addSong("Teri mitti",434);
        kesari.addSong("Ve mahi",232);
        kesari.addSong("Sanu kehndi",200);
        kesari.addSong("Deh shiva", 204);
        albums.add(kesari);
        /////////////////////////////////////KABIR SINGH//////////////////////////////////

        Album kabirSingh =new Album("Kabir Singh");
        kabirSingh.addSong("Bekhayali", 343);
        kabirSingh.addSong("Kaise hua", 256);
        kabirSingh.addSong("Mere Soneya", 156);
        kabirSingh.addSong("Yeh aaina", 123);
        kabirSingh.addSong("Pehla pyarr", 234);
        kabirSingh.addSong("Tujhe kitna chahne lage", 309);
        albums.add(kabirSingh);
        ///////////////////////////////////////////////////////////////////////

        LinkedList<Song>  playlist = new LinkedList<Song>();
        albums.get(0).AddToPlaylist("Hum mar jayenge",playlist);
        albums.get(0).AddToPlaylist("Tum hi ho",playlist);
        albums.get(0).AddToPlaylist("Chahun mai ya na",playlist);
        albums.get(0).AddToPlaylist("Bhula dena",playlist);
        albums.get(0).AddToPlaylist("Milne hai mujhse aayi",playlist);

        albums.get(1).AddToPlaylist("Teri mitti",playlist);
        albums.get(1).AddToPlaylist("Sanu kehndi",playlist);
        albums.get(1).AddToPlaylist("unknown",playlist);

        albums.get(2).AddToPlaylist("Bekhayali",playlist);
        albums.get(2).AddToPlaylist("Tujhe kitna chahne lage",playlist);
        albums.get(2).AddToPlaylist("Kaise hua",playlist);
        albums.get(2).AddToPlaylist("unknown2",playlist);


        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> i= playlist.listIterator();
        System.out.println("Now playing "+i.next().toString());    //playing the first song

        boolean quit = false;
        boolean movingForward = true;
        System.out.println("===============================================");
        printMenu();

        while (!quit) {
            System.out.println("Enter : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0://quit
                    System.out.println("We are closing the playlist !");
                    quit=true;
                    break;
                case 1://skip to next song
                    if(!movingForward){
                        if (i.hasNext()){
                            i.next();
                        }
                        movingForward=true;
                    }
                    if (i.hasNext()){
                        System.out.println("Jumped to the next song");
                        System.out.println("Now playing "+i.next().toString());
                    }else{
                        System.out.println("It is the end of the playlist");
                        movingForward=false;
                    }
                    break;
                case 2://skip to the previous song
                    if (movingForward){
                        if (i.hasPrevious()){
                            i.previous();
                        }
                        movingForward=false;
                    }
                    if (i.hasPrevious()){
                        System.out.println("Jumed back to the previous song");
                        System.out.println("Now playing "+i.previous().toString()   );
                    }else{
                        System.out.println("It is the start of the playlist");
                        movingForward=true;
                    }
                    break;
                case 3://replay the current song
                    if(movingForward){
                        if (i.hasPrevious()){
                            System.out.println("Now replaying "+i.previous().toString());
                            movingForward=false;
                        }else{
                            System.out.println("It is the start of the playlist");
                        }
                    }
                    else if (!movingForward){
                        if (i.hasNext()){
                            System.out.println("Now replaying "+i.next().toString());
                            movingForward=true;
                        }
                        else{
                            System.out.println("It is the end of the playlist");
                        }
                    }
                    break;
                case 4://list song in playlist
                    printList(playlist);
                    break;
                case 5://print menu
                    printMenu();
                    break;
                case 6://remove
                    if (playlist.size()>0){
                        i.remove();
                        if (i.hasNext()){
                            System.out.println("Now playing "+ i.next());
                        }else if(i.hasPrevious()){
                            System.out.println("Now playing "+ i.previous());
                        }
                    }
                    break;
            }

        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }
















}
