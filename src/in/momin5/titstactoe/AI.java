package in.momin5.titstactoe;

import java.util.Random;

/**
 * @author MOMIN5
 * @since 21st August 2021
 *
 * A side note that this isnt an actual AI, a AI takes user inputs and learns from it,
 * this one just tries to make 3 checks in a particular order/pattern
 * making an actual AI is pretty complicated, maybe in the future i might try that
 */
public class AI {

    public void doOpponentMove() {

        // this is the class which helps in making random ints, doubles and a lot of cool things
        var random = new Random();

        // save the random val to an int
        // NOTE: 9 is the range so it will create random ints from 0 to 8, so we can just add 1 to get random from 1 - 9
        int randomInt = random.nextInt(9) + 1;

        // check if the move has been played or not, if yes then regenerate and check again
        while (Main.playedPos.contains(randomInt)) {
            randomInt = random.nextInt(9) + 1;
        }

        mapInput(randomInt);

        Main.playedPos.add(randomInt);
    }

    public void mapInput(int input) {
        var output = "X";

        // sets the variable to the output which changes the string
        // its probs not the best way to do it but ye
        switch (input) {
            case 1 -> Main.one = output;
            case 2 -> Main.two = output;
            case 3 -> Main.three = output;
            case 4 -> Main.four = output;
            case 5 -> Main.five = output;
            case 6 -> Main.six = output;
            case 7 -> Main.seven = output;
            case 8 -> Main.eight = output;
            case 9 -> Main.nine = output;

            // so basically i found about this today and its pretty cool, if no other inputs match these above numbers ^^
            // then the users probably entered a invalid int so it just exits the program
            default -> {
                System.out.println("Not a valid input! Please read the input instructions again!");
                System.exit(0);
            }
        }
    }


}
