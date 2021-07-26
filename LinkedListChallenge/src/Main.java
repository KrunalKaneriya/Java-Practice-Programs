// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove())

import javax.naming.LinkLoopException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static LinkedList<Song>playList = new LinkedList<>();
    public static LinkedList<Song>sample = new LinkedList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Album starboy = new Album("Starboy","The Weeknd");
        starboy.addSong("StarBoy","04:55");
        starboy.addSong("I Feel It Coming","02:59");
        starboy.addSong("Party Monster","04:09");
        starboy.addSong("False Alarm","03:09");
        starboy.addSong("Reminder","03:38");
        starboy.addSong("Rockin","03:52");
        starboy.addSong("Secrets","04:25");
        starboy.addSong("True Colors","03:26");

        Album haunted = new Album("Haunted","Various Artists");
        haunted.addSong("Jaaniya","05:56");
        haunted.addSong("Tera Hi Bas Hona Chahoon","06:01");
        haunted.addSong("Tum Ho Mera Pyaar","05:05");
        haunted.addSong("Mujhe De De Har Gham Tera","04:57");
        haunted.addSong("Sau Baras","05:04");


        starboy.addToPlaylist("StarBoy",playList);
        starboy.addToPlaylist("I Feel It Coming",playList);
        starboy.addToPlaylist("Party Monster",playList);
        starboy.addToPlaylist("False Alarm",playList);
        starboy.addToPlaylist("Rockin",playList);
        starboy.addToPlaylist("Secrets",playList);
        starboy.addToPlaylist("Reminder",playList);
        haunted.addToPlaylist("Jaaniya",playList);
        haunted.addToPlaylist("Tera Hi Bas Hona Chahoon",playList);
        haunted.addToPlaylist("Tum Ho Mera Pyaar",playList);

        play(playList);



    }

    private static boolean addSongToPlayList(Song song) {
        if(song!=null) {
            playList.add(song);
            System.out.println("Song " + song.getSongName() + " added To playlist");
            return true;
        }
        return false;
    }

    private static void play(LinkedList<Song>playList) {
        ListIterator<Song>listIterator = playList.listIterator();
        boolean quit = false;
        boolean isForward = true;

//        if(playList.isEmpty()) {
//            System.out.println("There Are No Songs To Play In PlayList. Add One First.");
//            return;
//        } else {
//            System.out.println("Now Playing: " + listIterator.next().toString());
//        }
        printMenu();

        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(!isForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            isForward = true;
                        }
                    }
                    if(listIterator.hasNext()) {

                        System.out.println("Now Playing: " + listIterator.next().toString());
                    }
                    else {
                        isForward = false;
                        System.out.println("The List is Ended..");

                    }
                    break;
                case 3:
                    if(isForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            isForward = false;
                        }
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now Playing: " + listIterator.previous().toString());
                    }
                    else {
                        System.out.println("We Are At Start of The List.");
                        isForward = true;
                    }
                    break;
                case 4:
                    for(int i=0;i< playList.size();i++) {
                        System.out.println((i+1) + " : " + playList.get(i).toString());
                    }
                    break;
                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid Choice..");
            }
        }
    }


    private static void printMenu() {
        System.out.println("1. Print The Menu Again..");
        System.out.println("2. Next Song.");
        System.out.println("3. Previous Song");
        System.out.println("4. Print PlayList");
        System.out.println("5. Quit");
    }


}
