package in.momin5.titstactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author MOMIN5
 * @since 20th August 2021
 */
public class Main {

    // probs a bad way to do this but this ones easiest and shortest
    public static String one,two,three,four,five,six,seven,eight,nine;
    public static List<Integer> playedPos = new ArrayList<>();

    public static void main(String[] args){

        // initialize the variables to
        one = two = three=four=five=six=seven=eight=nine =" ";

        // the input system
        var scanner = new Scanner(System.in);
        var ai = new AI();

        // this is how the inputs gonna work
        var demoLocations = """
                1 | 2 | 3
                4 | 5 | 6
                7 | 8 | 9
                """;

        // print all the start stuff and instructions
        System.out.println("Hello! Welcome to TicTacToe! This is a fun game made by MOMIN5 \nFor more info check out my github! https://github.com/MOMIN5 ;)\nThis is how you input the locations \n\n" + demoLocations);
        System.out.println("Now lets get started! \nPlease enter a number: \n ");

        ai.doOpponentMove();

        //System.out.println("Computers Turn");

        var str = String.format("""
                        %s | %s | %s
                        %s | %s | %s
                        %s | %s | %s
                        """, one, two, three, four, five, six, seven, eight, nine);

        System.out.println(str);

        while (scanner.hasNext()) {
            // takes the input as variable and converts it to the location on string map
            var input = scanner.nextInt();

            // check if the position is already played
            if (!playedPos.contains(input)) {

                playedPos.add(input);

                mapInput(input);

                ai.doOpponentMove();

                var map = String.format("""
                        %s | %s | %s
                        %s | %s | %s
                        %s | %s | %s
                        """, one, two, three, four, five, six, seven, eight, nine);

                System.out.print(map);
                System.out.println("You played the " + input + "th position!");

                if(checkForPlayerMatch()) {
                    System.out.println("Congrats! You Won against The Computer!");
                    System.exit(0);
                }
                if(checkForEnemyMatch()) {
                    System.out.println("Aww! You lost! Better luck next time");
                    System.exit(0);
                }
            } else {
                System.out.println("That position is already played! Please enter another number: ");
            }
        }

        // map the locations on the string
    }

    // returns the position on the string map
    private static void mapInput(int input) {
        // create one variable instead of creating new string everytime
        // EDIT : IT MIGHT BE THE SAME IM NOT SURE
        var output = "O";

        // sets the variable to the output which changes the string
        // its probs not the best way to do it but ye
        switch (input) {
            case 1 -> one = output;
            case 2 -> two = output;
            case 3 -> three = output;
            case 4 -> four = output;
            case 5 -> five = output;
            case 6 -> six = output;
            case 7 -> seven = output;
            case 8 -> eight = output;
            case 9 -> nine = output;

            // so basically i found about this today and its pretty cool, if no other inputs match these above numbers ^^
            // then the users probably entered a invalid int so it just exits the program
            default -> {
                System.out.println("Not a valid input! Please read the input instructions again!");
                System.exit(0);
            }
        }
    }

    /**
     * Checks if the board has a match for player or not
     */
    static boolean checkForPlayerMatch() {

        /* i know this is a bad way to do this, if you dont want to hardcode values then you can make variables for
           the player and the enemy prefix (for O and X), this is the easiest way i could come up with,
           one other solution i came up with was putting enemy and player moves in a seperate array,
           then looping them trough 1-3,4-6 and so on, but that would require me to make seperate arrays
           this one might not look good but its the most easiest
         */
        // the horizontals matches
        if(one.equals("O") && two.equals("O") && three.equals("O") || four.equals("O") && five.equals("O") && six.equals("O") || seven.equals("O") && eight.equals("O") && nine.equals("O")) {
            return true;
        }
        // the vertical matches
        if(one.equals("O") && four.equals("O") && seven.equals("O") || two.equals("O") && five.equals("O") && eight.equals("O") || three.equals("O") && six.equals("O") && nine.equals("O")) {
            return true;
        }
        // the diagonal ones
        if(one.equals("O") && five.equals("O") && nine.equals("O") || three.equals("O") && five.equals("O") && seven.equals("O")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the board has a match for enemy or not
     */
    static boolean checkForEnemyMatch() {
        // the horizontals matches
        if(one.equals("X") && two.equals("X") && three.equals("X") || four.equals("X") && five.equals("X") && six.equals("X") || seven.equals("X") && eight.equals("X") && nine.equals("X")) {
            return true;
        }
        // the vertical matches
        if(one.equals("X") && four.equals("X") && seven.equals("X") || two.equals("X") && five.equals("X") && eight.equals("X") || three.equals("X") && six.equals("X") && nine.equals("X")) {
            return true;
        }
        // the diagonal ones
        if(one.equals("X") && five.equals("X") && nine.equals("X") || three.equals("X") && five.equals("X") && seven.equals("X")) {
            return true;
        }
        return false;
    }
}
