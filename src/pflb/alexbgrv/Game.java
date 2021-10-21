package pflb.alexbgrv;

import java.io.IOException;

import java.util.*;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private MessageBuilder messages = new MessageBuilder();
    private Data data = new Data();
    private Logic logic = new Logic();
    private FileReadWrite output = new FileReadWrite();

    public Game() throws IOException {
    }

    public void startGame() throws IOException {
        data.initGame();
        System.out.println("Игра началась, начинайте отгадывать строку:");
        output.logWriter(messages.startGame(data));
        boolean checkGame = true;
        while(checkGame) {
            String userInput = scanner.nextLine();
            ArrayList<Integer> listOfBullsAndCows = logic.bullsAndCows(data, userInput);
            messages.attemptBuilder(data, userInput, messages.message(data ,listOfBullsAndCows));
            System.out.println(data.getLastUserAttempt());
            output.logWriter(data.getLastUserAttempt());
            if(listOfBullsAndCows.get(0) == 4) {
                checkGame = false;
                System.out.println(messages.attemptWin(data));
                output.logWriter(messages.attemptWin(data));
            }
        }
    }

}
