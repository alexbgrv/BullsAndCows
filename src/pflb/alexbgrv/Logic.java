package pflb.alexbgrv;

import java.util.ArrayList;

public class Logic {
    public ArrayList<Integer> bullsAndCows(Data data, String userInput) {
        int[] arrOfAnimals = new int[4];
        int cows = 0;
        int bulls = 0;
        ArrayList<Integer> listOfBullsAndCows = new ArrayList<>();
        listOfBullsAndCows.add(bulls);
        listOfBullsAndCows.add(cows);
        for (int i = 0; i < userInput.length(); i++) {
            arrOfAnimals[i] = userInput.charAt(i) - '0';
        }
        for (int i = 0; i < data.getArrOfAnimals().size(); i++) {
            if (data.getArrOfAnimals().get(i) == arrOfAnimals[i]) {
                bulls = bulls + 1;
                listOfBullsAndCows.set(0, bulls);
            }
            for (int j = 0; j < data.getArrOfAnimals().size(); j++) {
                if (data.getArrOfAnimals().get(i) == arrOfAnimals[j] && data.getArrOfAnimals().get(i) != arrOfAnimals[i]) {
                    cows = cows + 1;
                    listOfBullsAndCows.set(1, cows);
                }
            }
        }
        return listOfBullsAndCows;
    }
}
