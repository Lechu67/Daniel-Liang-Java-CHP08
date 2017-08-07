package Utilities;

/**
 * Created by Lechu on 2017-07-06.
 */

import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.printf("%nEnter your regex: ");
        Pattern pattern =
                Pattern.compile(in.nextLine());

        System.out.printf("Enter input string to search: ");
        Matcher matcher =
                pattern.matcher(in.nextLine());

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            System.out.printf("No match found.%n");
        }
        in.close();
    }

}