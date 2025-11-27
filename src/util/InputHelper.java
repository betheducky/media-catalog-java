package util;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    };

    public static int readInt(String prompt) {
        while(true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer: ");
            }
        }
    }

    public static Double readDouble(String prompt) {
        while(true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid double: ");    
            }
        }
    }

    public boolean readYesNo (String prompt) {
        System.out.print(prompt + " (y/n): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.startsWith("y");
    }

}
