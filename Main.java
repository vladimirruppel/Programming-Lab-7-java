import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TrackList> lists = new ArrayList<>();

        AudioFile track1 = new AudioFile("file1.mp3", "Kanye West", "Good Morning", 203, 2007);
        AudioFile track2 = new AudioFile("file2.mp3", "Kanye West", "Ni**as in Paris", 243, 2011);
        AudioFile track3 = new AudioFile("file3.mp3", "Скриптонит", "Космос", 181, 2017);
        AudioFile track4 = new AudioFile("file4.mp3", "FRIENDLY THUG 52 NGG", "No Gletcher Gang", 173, 2023);

        ArrayList<AudioFile> albumTracks = new ArrayList<AudioFile>();
        albumTracks.add(track1); albumTracks.add(track2);

        try {
            lists.add(new Playlist("Крутой плейлист", track1, track2, track3));
            lists.add(new TrackList(track4));
            lists.add(new Album("Kanye West", "Graduation", albumTracks)); // конструктор выбрасывает исключения
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("В самом начале:");
        DisplayLists(lists);
    }

    private static void DisplayLists(ArrayList<TrackList> lists) {
        int i = 1;
        for (TrackList list : lists) {
            System.out.print("Треклист #" + i++ + ":\n");
            list.Display();
        }
    }
}