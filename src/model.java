import java.io.*;
import java.util.Scanner;

public class model {

    // ska läsa fillen med datan
    public String fileReader(){
        String fileInput = "krypt_fill.txt";
        String data = null;
        try {
            File input = new File(fileInput);
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()){
                data = reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ingen file eller kunde inte läsa file");
            e.printStackTrace();
        }
        return data;
    }
    //krypteraren
    public void kryptering (String data){
        //her sring informationen till en char array
        char[] chars = data.toCharArray();
        for (int i = 0; i < data.length(); i++) {
            chars[i] = data.charAt(i);
        }
        //Gör en char till int kryptera sen till binary.
        for (int i = 0; i < chars.length; i++) {
            int charTOint = chars[i];
            int kry_meddelande = Cmk(charTOint);
            String intTObinary = Integer.toBinaryString(kry_meddelande);

        }
    }
    private int key(){
        String fileInput = "key.txt";
    }

    private int Cmk(int charTOint) {
        int m = charTOint;
        int k =   ;
        int c = m^k;

        return c;
    }

    // ska över den krypterade informationen till en fill
    /* public void fileWriter(){
        String filOutbut = "outbut.txt";
        try {
            FileWriter fw = new FileWriter(filOutbut);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
    // https://www.programiz.com/java-programming/bufferedreader
    // https://www.programiz.com/java-programming/bufferedwriter
}