package kata4.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    
    public static List<String> read(String file) throws FileNotFoundException, IOException {
        List<String> mailList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String mail;
            while ((mail = reader.readLine()) != null) {
                if (mail.contains("@")) mailList.add(mail);
            }
        }
        return mailList;
    }
    
}