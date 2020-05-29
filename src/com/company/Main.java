/*
 * Classname Main
 *
 * Version info 1
 *
 * Copyright Serhii Tronevych KNUTE
 */
package com.company;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\harry.txt")));

        String cleanerText = text
                .toLowerCase()
                .replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("\"", "")
                .replaceAll("!", "")
                .replaceAll(";", "")
                .replaceAll(":", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\?", "");

        // System.out.println(cleanerText);

        //Task 1. Find the longest word in the above text.

        String words[] = text.split("[^a-zA-Z]");
        int i, size = words.length;
        int iMax = -1, iMaxLength = -1;
        for (i = 0; i < size; ++i)
            if (!"".equals(words[i]) && words[i].length() > iMaxLength) {
                iMax = i;
                iMaxLength = words[i].length();
            }
        if (iMax == -1)
            System.err.println("String has no contains words");
        else
            System.out.println("Index = " + iMax + "\tword = " + words[iMax]);

        // Task 2. Count the lines where the word "Harry" is met.

        String word = "Harry";
        String words2[] = text.split(" ");
        int counter = 0;
        for (int f = 0; f < words2.length; f++) {
            if (word.equals(words2[f]))
                counter++;
        }
        System.out.println("The word " + word + " occurs " + counter + " times in the above book");

        // Task 3. Take array of distinct words from Harry Potter. Create an array of hashes.


        String distinktString = " ";

        for (int j = 0; j < words.length; j++) {
            if (!distinktString.contains(words[j])) {
                distinktString += words[j] + " ";
            }
        }
        String[] distrinctArray = distinktString.split(" ");
        for (int j = 0; j < distrinctArray.length; j++) {
            System.out.println(distrinctArray[j].hashCode());
        }

        // Task 4. Count the intersections.

        int intersections = 0;
        for (int s = 0; s < distrinctArray.length; s++) {
            for (int z = s + 1; z < distrinctArray.length; z++) {
                if (distrinctArray[s].equals(distrinctArray[z])) {
                    intersections++;
                    // got the duplicate element
                }
            }
        }
        if ( intersections == 0 )
            System.out.println(intersections + " - Хешкоди немають збігів");
    }}

