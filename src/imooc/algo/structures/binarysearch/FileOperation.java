package imooc.algo.structures.binarysearch;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class FileOperation {

    public static boolean readFile(String filename, Vector<String> words) {
        System.out.println(filename);

        if (filename == null) {
            System.out.println("file name is null");
            return false;
        }

        Scanner scanner;

        System.out.println("==== start ====");

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println(file.exists());
            return false;
        }

        System.out.println("==== file ok =====");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fileInputStream), "UTF-8");
            scanner.useLocale(Locale.ENGLISH);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
            return false;
        }

        System.out.println("==== file stream okay =====");

        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i < contents.length();) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        return true;

    }

    private static int firstCharacterIndex(String s, int start){

        for( int i = start ; i < s.length() ; i ++ )
            if( Character.isLetter(s.charAt(i)) )
                return i;
        return s.length();
    }
}
