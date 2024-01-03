import java.util.ArrayList;
import java.util.Collections;

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

        // сортировка по количеству треков в треклисте
        Collections.sort(lists, (a, b) -> Integer.compare(a.GetSize(), b.GetSize()));

        System.out.println("После сортировки по количеству треков в плейлисте:");
        DisplayLists(lists);

        // поиск по имени треки
        String searchName = "Космос";
        TrackList result = lists.stream()
                .filter(list -> list.Contains(searchName))
                .findFirst()
                .orElse(null);

        System.out.println("Найденный треклист с треком с названием \"" + searchName + "\":");
        result.Display();
    }

    private static void DisplayLists(ArrayList<TrackList> lists) {
        System.out.print("Количества прослушиваний треков: ");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i).GetSize());
            if (i < lists.size() - 1) System.out.print(", ");
        }
        System.out.println("\n");
    }

}