package Algorithms.Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong


        boolean isUpper = false;
        boolean islower = false;
        boolean isNumber = false;
        boolean isSpecial = false;

        for (int i=0;i<password.length();i++) {
            int ch = password.charAt(i);
            if (ch>='A' && ch<='Z') {
                isUpper = true;
            } else if (ch>='a' && ch <='z') {
                islower = true;
            } else if (ch>='0' && ch<='9') {
                isNumber = true;
            } else {
                isSpecial = true;
            }
        }

        int count  = 0;

        if (!isUpper) {
            count ++;
        }
        if (!islower) {
            count ++;
        }

        if (!isNumber) {
            count++;
        }

        if(!isSpecial) {
            count++;
        }

        return Math.max(count, 6 - password.length());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/arumugam/Documents/Projects/Hackerrank/src/main/resources/Solution1.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
