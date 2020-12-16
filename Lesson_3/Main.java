import com.chat.auth.UserRepository;
import com.chat.auth.UserService;
import com.chat.entity.User;
import com.chat.server.ChatServer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        SELECT * FROM users WHERE login = ? AND password = ?

//        UserService userService = new UserService();
//        User user = new User(0,"User");
//        userService.save(user);
//        System.out.println(userService.findAll());

        printLastNLines(2);

    }

    private static void printLastNLines(int count) {
        try (
                FileInputStream fin =
                     new FileInputStream(
                             "C:\\Users\\Princ\\Desktop\\Java\\Lessons\\Lesson_2\\src\\com\\chat\\server\\history.txt"
                     );
                BufferedReader br =
                     new BufferedReader(new InputStreamReader(fin))
        ) {
            String line;
            List<String> tempLines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                tempLines.add(line);
            }

            for (int i = count; i < tempLines.size(); i++) {
                System.out.println(tempLines.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
