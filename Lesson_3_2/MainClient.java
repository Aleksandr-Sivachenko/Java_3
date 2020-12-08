package io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainClient {

    public static void main(String[] args) {
        printLastNLines(10);
    }

    private static void printLastNLines(int count) {
        try(
                FileInputStream fin =
                    new FileInputStream(
                            "C:\\Users\\Princ\\Desktop\\Java\\Lessons\\Lesson_3(2)\\src\\io\\log.text"
                    );
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(fin))
        ) {
            String line;
            List<String> tempLines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                tempLines.add(line);
            }

            for (int i = tempLines.size() - count; i < tempLines.size(); i++) {
                System.out.println(tempLines.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
