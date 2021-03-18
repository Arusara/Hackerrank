package Algorithms.Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {

        Set<Integer> set = new HashSet<Integer>();
        String[] result = new String[queries.length];

        char prev = ' ';
        int weight = 0;

        for (int i=0;i<s.length();i++) {

            char curr = s.charAt(i);
            if (curr!=prev) {
               weight = 0;
            }

            weight = weight + curr - 'a' + 1;
            set.add(weight);
            prev = curr;
        }


        for (int i=0;i<queries.length; i++) {

            if (set.contains(queries[i])) {
                result[i] = "Yes";
            } else  {
                result[i] = "NO";
            }

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/arumugam/Documents/Projects/Hackerrank/src/main/resources/Solution.txt"));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
