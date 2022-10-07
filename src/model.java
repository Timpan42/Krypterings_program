import java.io.*;
import java.util.Scanner;

  public class model {
      public static void main(String[] args) {
          String m = fileReader();
          String k = key();
          model crypModel = new model();
          String file = "Model_fil";
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
          String svar = crypModel.cryptSting(m,k);
          String svarX = crypModel.cryptSting(svar,k);
          System.out.println(svar);
          System.out.println(svarX);



          System.out.println();

          try {
              FileWriter myWriter = new FileWriter(file);
              myWriter.write(svar);
              myWriter.write("\n" + svarX);
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
          }

      }


    // ska läsa fillen med datan
    public static String fileReader(){
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

// kalla nyckeln
    private static String key(){
        String fileInput = "key.txt";
        String key = null;
        try {
            File input = new File(fileInput);
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()){
                key = reader.nextLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ingen file eller kunde inte läsa file");
            e.printStackTrace();
        }
        return key;
    }
        //krypt med en String
      private String cryptSting(String message, String key) {
          String svar = "";
          while (key.length() < message.length()){
              key = expandKey(key);
          }
          for (int i = 0; i < message.length(); i++) {
              svar += (char)crypt(message.charAt(i), key.charAt(i));
          }
          return svar;
      }

      // long nyckel
      private String expandKey(String key) {
          return key+key;
      }

      // kryptera
      private int crypt( int m,  int k) {
          return m^k;
      }









    /*
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
    }*/



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