package com.github.zjgyjd.onechase;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Police police;
    private Thief thief;
    private char map[][];
    private String article;

    public Game(Police police, Thief thief) {
        this.police = police;
        this.thief = thief;
        map = new char[10][10];

    }

    public static void main(String[] args) {
        char[][] s = new char[10][10];
        String s1 = "";
        drawMap(s);
        showMap(s);
        showArticle(s1 = writeArticle(s1));

        checkArt(s1);
    }

    private static void checkArt(String s1) {
        int len = s1.length();
        int i = 0;

        while (i < len) {
            try {
                BufferedInputStream br = new BufferedInputStream(System.in);
                BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
                char[] temp = null;
                char[] read = new char[5];
                b.read(read);
                System.out.println(read[0]+"长度为:"+read.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    void start() {
        drawMap(map);
        showMap(map);
        article = writeArticle(article);
        showArticle(article);
    }

    private static String writeArticle(String article) {
        File art = Paths.get("D:", "a girl selling matches.txt").toFile();
        try (
                InputStream in = new FileInputStream(art);
                Scanner s = new Scanner(in)
        ) {
            article = s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article;
    }

    private static void showArticle(String article) {
        System.out.println(article);
    }

    public static void drawMap(char map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length;
                 j++) {
                if (i == 0 || j == 0 || i == map.length - 1 || j == map[i].length - 1
                        || i == 2 || j == 2 || i == map.length - 3 || j == map.length - 3) {
                    if (i == 1) {
                        if (j == 2 || j == map[i].length - 3) {
                            continue;
                        }
                    }
                    if (j == 1) {
                        if (i == 2 || i == map[i].length - 3) {
                            continue;
                        }
                    }
                    if (i == map[i].length - 2) {
                        if (j == 2 || j == map[i].length - 3) {
                            continue;
                        }
                    }
                    if (j == map[i].length - 2) {
                        if (i == 2 || i == map[i].length - 3) {
                            continue;
                        }
                    }
                    map[i][j] = '*';
                }
            }
        }
    }

    public static void showMap(char map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length;
                 j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
