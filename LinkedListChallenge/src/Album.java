import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private List<Song>songsList;
    private String albumName;
    private String artistName;

    public Album( String albumName,String artist) {
        this.songsList = new ArrayList<>();
        this.albumName = albumName;
        this.artistName = artist;
    }

    public boolean addSong(String songName,String duration) {
        Song tempSong = new Song(songName,duration);
        if(findSong(tempSong)==null) {
            this.songsList.add(tempSong);
            return true;
        }
        return false;

    }

    private Song findSong(String songName) {
        for(Song tempSong:songsList) {
            if(tempSong.getSongName().equals(songName)) {
                return tempSong;
            }
        }
        return null;
    }

    private Song findSong(Song song) {
        for(Song tempsong:songsList) {
            if(tempsong.getSongName().equalsIgnoreCase(song.getSongName()))  {
                System.out.println("Song is Already Added in List.");
                return tempsong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(String songName, LinkedList<Song>playList) {
        Song tempSong = findSong(songName);
        if(tempSong!=null) {
            playList.add(tempSong);
            System.out.println("Song: " + tempSong.getSongName() + " Added To PlayList");
            return true;
        }
        else {
            System.out.println("Song Not Found In Album");
        }
        return false;
    }


}
