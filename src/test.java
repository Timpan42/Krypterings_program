import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    private String message;
    private String key;
    private String crypt;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCrypt() {
        return crypt;
    }

    private String crypSting() {
        String svar = "";
        while (key.length() < message.length()) {
            key = expandKey(key);
        }
        for (int i = 0; i < message.length(); i++) {
            svar += (char) crypt(message.charAt(i), key.charAt(i));
        }
        return svar;
    }

    private String expandKey(String key) {
        return key + key;
    }

    private int crypt(int m, int k) {
        return m ^ k;
    }

    public static void main(String[] args) {
        String m = "hej på dig";
        String k = "12371235";
        String file ="test_fil_skaparen.txt";
        String rolig = "Det ska vara en rolig krypterat sak här";

        test crypModel = new test();
        crypModel.setMessage(m);
        crypModel.setKey(k);
        crypModel.crypSting();
        System.out.println(crypModel.getCrypt());
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(rolig);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

