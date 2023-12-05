package com.duneth;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Album1","AC/DC");

        album.addSong("Daatha dara",4.5);
        album.addSong("Ale mal",3.5);
        album.addSong("Rathriya manaram kiya",5.0);
        albums.add(album);

        album = new Album("Album2","Eminem");

        album.addSong("Kuweniye",4.5);
        album.addSong("Kadu para atha aine",3.5);
        album.addSong("Oba apple malak",4.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Daatha dara",playList_1);
        albums.get(0).addToPlayList("Ale mal",playList_1);
        albums.get(1).addToPlayList("Kuweniye",playList_1);
        albums.get(1).addToPlayList("Oba apple malak",playList_1);

        play(playList_1);
    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean foward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }
        else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!foward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        foward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else{
                        System.out.println("no song available, reached to the end of the list");
                        foward = false;
                    }
                    break;
                case 2:
                    if(foward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        foward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " +listIterator.previous().toString());
                    }else{
                        System.out.println("we are the first song");
                        foward = false;
                    }
                    break;
                case 3:
                    if(foward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            foward = false;
                        }else{
                            System.out.println("we are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing " +listIterator.next().toString());
                            foward = true;
                        }else{
                            System.out.println("we have reached to the end of the lsit");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();;
                        if(listIterator.hasNext()){
                            System.out.println("now playing " +listIterator.next().toString());
                        } else{
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }


            }
        }

    }
    private static void printMenu(){
        System.out.println("Available options \n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("______________");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________");
    }
}
