package pflb.alexbgrv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Data {
    FileReadWrite output = new FileReadWrite();
    private ArrayList<Integer> arrOfAnimals;
    private LocalDateTime localDateTime;
    private ArrayList<String> userAttempts;
    private int gameId;

    public Data() throws FileNotFoundException {
    }

    public void initGame() throws IOException {
        this.arrOfAnimals = randomNumbers();
        this.localDateTime = LocalDateTime.now();
        this.userAttempts = new ArrayList<>();
        this.gameId = output.getLastGameId();
    }

    public int getGameId() {
        return this.gameId;
    }

    public ArrayList<String> getUserAttempts() {
        return userAttempts;
    }

    public String getLastUserAttempt() {
        return this.userAttempts.get(userAttempts.size() - 1);
    }

    public void setUserAttempts(String userAttempt) {
        this.userAttempts.add(userAttempt);
    }

    public ArrayList<Integer> getArrOfAnimals() {
        return arrOfAnimals;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    private ArrayList<Integer> randomNumbers() {
        HashSet<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 4) {
            randomNumbers.add(0 + (int) (Math.random() * 9));
        }
        ArrayList<Integer> shuffledNumbers = new ArrayList<>(randomNumbers);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }
}
