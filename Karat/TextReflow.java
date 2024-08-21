package Karat;

import java.util.ArrayList;
import java.util.List;

//We are building a word processor and we would like to implement a "reflow" functionality that also applies full justification to the text.
//        Given an array containing lines of text and a new maximum width, re-flow the text to fit the new width. Each line should have the exact specified width. If any line is too short, insert '-' (as stand-ins for spaces) between words as equally as possible until it fits.
//        Note: we are using '-' instead of spaces between words to make testing and visual verification of the results easier.
//
//        lines = [ "The day began as still as the",
//        "night abruptly lighted with",
//        "brilliant flame" ]
//
//        reflowAndJustify(lines, 24) ... "reflow lines and justify to length 24" =>
//
//        [ "The--day--began-as-still",
//        "as--the--night--abruptly",
//        "lighted--with--brilliant",
//        "flame" ] // <--- a single word on a line is not padded with spaces
public class TextReflow {

    public static List<String> reflowAndJustify(String[] lines, int maxLen) {
        if (lines == null || lines.length == 0) {
            return new ArrayList<>();
        }

        // Step 1: Combine all lines into a single string and split into words.
        StringBuilder content = new StringBuilder();
        for (String line : lines) {
            if (content.length() > 0) {
                content.append(" ");
            }
            content.append(line);
        }
        String[] words = content.toString().split(" ");

        // Step 2: Reflow words into lines of maximum length maxLen.
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int count = 0;
            int len = 0;

            // Step 3: Find how many words fit into the line.
            while (i + count < words.length && len + words[i + count].length() + count <= maxLen) {
                len += words[i + count].length();
                count++;
            }

            // Step 4: Justify the line by adding dashes.
            StringBuilder line = new StringBuilder();
            int totalSpaces = maxLen - len;
            int spaceBetweenWords = count > 1 ? totalSpaces / (count - 1) : totalSpaces;
            int extraSpaces = count > 1 ? totalSpaces % (count - 1) : 0;

            for (int j = 0; j < count; j++) {
                if (line.length() > 0) {
                    for (int k = 0; k < spaceBetweenWords; k++) {
                        line.append('-');
                    }
                    if (extraSpaces > 0) {
                        line.append('-');
                        extraSpaces--;
                    }
                }
                line.append(words[i + j]);
            }

            // If it's a single word, no extra dashes are needed.
            while (line.length() < maxLen) {
                line.append('-');
            }

            result.add(line.toString());
            i += count;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] lines = {
                "The day began as still as the",
                "night abruptly lighted with",
                "brilliant flame"
        };
        int maxLen = 24;

        List<String> justifiedText = reflowAndJustify(lines, maxLen);
        for (String line : justifiedText) {
            System.out.println(line);
        }
    }
}
