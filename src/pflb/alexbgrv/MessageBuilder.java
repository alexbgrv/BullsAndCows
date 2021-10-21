package pflb.alexbgrv;

import java.util.ArrayList;

public class MessageBuilder {
    private ArrayList<String> userAttempt = new ArrayList<>();
    public String message(Data data, ArrayList<Integer> listOfBullsAndCows) {
        String str1 = "";
        String str2 = "";
        if (listOfBullsAndCows.get(0) == 1) {
            str1 = listOfBullsAndCows.get(0) + "\sбык и\s";
        } else if (listOfBullsAndCows.get(0) == 0) {
            str1 = listOfBullsAndCows.get(0) + "\sбыков и\s";
        } else if (listOfBullsAndCows.get(0) >= 2 && listOfBullsAndCows.get(0) <= 4) {
            str1 = listOfBullsAndCows.get(0) + "\sбыка и\s";
        }
        if (listOfBullsAndCows.get(1) == 1) {
            str2 = listOfBullsAndCows.get(1) + "\sкорова";
        } else if (listOfBullsAndCows.get(1) == 0) {
            str2 = listOfBullsAndCows.get(1) + "\sкоров";
        } else if (listOfBullsAndCows.get(1) >= 2 && listOfBullsAndCows.get(1) <= 4) {
            str2 = listOfBullsAndCows.get(1) + "\sкоровы";
        }
        return str1 + str2;
    }

    public void attemptBuilder(Data data, String userInput, String bullsAndCowsOut) {
        data.setUserAttempts("Запрос:\s" + userInput + "\sОтвет:\s" + bullsAndCowsOut);
    }

    public String attemptWin(Data data) {
        return "Вы победили, кол-во попыток:\s"+ data.getUserAttempts().size();
    }

    public String startGame(Data data) {
        return  "Game\s№"+ data.getGameId() + "\s" + data.getLocalDateTime().toLocalDate() + "\s" + data.getLocalDateTime().toLocalTime().getHour()+ ":"
                + data.getLocalDateTime().toLocalTime().getMinute() + "\sЗагаданная строка\s"
                + data.getArrOfAnimals().get(0) + data.getArrOfAnimals().get(1) + data.getArrOfAnimals().get(2) + data.getArrOfAnimals().get(3);
    }
}
