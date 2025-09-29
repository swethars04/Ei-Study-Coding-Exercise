package behavioural_design_pattern;

// The Strategy interface
interface PlayStrategy {
    String play(String[] playlist, int currentIndex);
}

// Concrete Strategy: Play songs in order
class NormalPlay implements PlayStrategy {
    public String play(String[] playlist, int currentIndex) {
        if (currentIndex < playlist.length) {
            return "Now playing (Normal): " + playlist[currentIndex];
        }
        return "End of playlist.";
    }
}

// Concrete Strategy: Play a random song
class ShufflePlay implements PlayStrategy {
    public String play(String[] playlist, int currentIndex) {
        int random = (int) (Math.random() * playlist.length);
        return "Now playing (Shuffle): " + playlist[random];
    }
}

// Concrete Strategy: Repeat current song
class RepeatOnePlay implements PlayStrategy {
    public String play(String[] playlist, int currentIndex) {
        return "Now playing (Repeat One): " + playlist[currentIndex];
    }
}

// Context class
class MusicPlayer {
    private PlayStrategy strategy;
    private String[] playlist;
    private int currentIndex = 0;

    public MusicPlayer(String[] playlist) {
        this.playlist = playlist;
    }

    public void setPlayStrategy(PlayStrategy strategy) {
        this.strategy = strategy;
    }

    public void playNext() {
        System.out.println(strategy.play(playlist, currentIndex));
        if (!(strategy instanceof RepeatOnePlay)) {
            currentIndex = (currentIndex + 1) % playlist.length;
        }
    }
}

// Demo/Client code
public class strategy {
    public static void main(String[] args) {
        String[] playlist = {"Song_A.mp3", "Song_B.mp3", "Song_C.mp3"};
        MusicPlayer player = new MusicPlayer(playlist);

        // Normal play
        player.setPlayStrategy(new NormalPlay());
        player.playNext();

        // Shuffle play
        player.setPlayStrategy(new ShufflePlay());
        player.playNext();

        // Repeat one play
        player.setPlayStrategy(new RepeatOnePlay());
        player.playNext();
    }
}
