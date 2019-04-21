package tur.patryk;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class TxtEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        System.out.println("App will remove all text inside .txt files in specified folder.");
        System.out.println("Chose drive letter: ");
        String source = sc.nextLine();

        System.out.println("Type folder/folders with all .txt files, use '/' with subfolders: ");
        String directory = sc2.nextLine();

        File path = new File(source + ":/" + directory);     //create specified path form user

        if (path.exists()) {

        try {

            String[] extensions = {"txt"};
            boolean recursive = false;      //check only path provided

            Collection files = FileUtils.listFiles(path, extensions, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext(); ) {
                File file = (File) iterator.next();
                System.out.println("File = " + file.getAbsolutePath());     //lists all .txt files from specified folder
            }

            System.out.println("Are You sure You want to delete content from all this files ? (Y/N)");
            String yesNo = sc3.nextLine();

            if (yesNo.equalsIgnoreCase("y")) {
                for (Iterator iterator = files.iterator(); iterator.hasNext(); ) {
                    File file = (File) iterator.next();
                    FileUtils.writeStringToFile(file, "", false);       //write white space to all .txt files in specified folder
                }
                System.out.println("Success");
            } else if (yesNo.equalsIgnoreCase("n")) {
                System.out.println("Bye Bye");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
            System.out.println("Path does not exist.");
        }
    }
}
