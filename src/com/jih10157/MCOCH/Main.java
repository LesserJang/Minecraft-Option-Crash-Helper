package com.jih10157.MCOCH;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args==null) new SelectFrame();
        else {
            boolean b = false;
            try { b = Boolean.valueOf(args[1]);
            } catch(NullPointerException|ArrayIndexOutOfBoundsException ignored) {}
            if(b) new SelectFrame(args[0]);
            else Run(new File(args[0]));
        }
    }

    static void Run(File file) {
        try {
            Scanner fileScan = new Scanner(new BufferedReader(new FileReader(file)));
            ArrayList<String> list = new ArrayList<>();
            while (fileScan.hasNextLine()) list.add(fileScan.nextLine());
            fileScan.close();
            String s;
            for (int i = 0; i < list.size(); i++) {
                s=list.get(i);
                if(s.contains("lang:")) {
                    String s1 = s.split("_")[0]+"_"+(s.split("_")[1].toUpperCase());
                    if(s.equals(s1)) return;
                    list.set(i, s1);
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            list.forEach(writer::println);
            writer.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
