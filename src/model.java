
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

  public class model {
      private String message;
      private String key;
      private String file;
      private String[] crypt_svar;
      private String[] crypt_message;
      private String crypt_key;
      private int row;

      public void setMessage(String message) {
          this.message = message;
      }

      public void setKey(String key) {
          this.key = key;
      }

      public void setFile(String file) {
          this.file = file;
      }

      public String[] getCrypt_svar() {
          return crypt_svar;
      }

      public String[] getCrypt_message() {
          return crypt_message;
      }

      public String getCrypt_key() {
          return crypt_key;
      }

      public int getRow(){
          return row;
      }

      //skapar fil
      private void makeFile() {
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
      }

      //prinar ut svaret i fil
      private void fileOutput() {
          try {
              FileWriter myWriter = new FileWriter(file);
              for (int i = 0; i < row; i++) {
                  myWriter.write(crypt_svar[i]);
                  System.out.println(crypt_svar[i]);
                  myWriter.write("\n");
              }
              for(int j = 0 ;  j < row ; j++){

              }
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
          }
      }


      // ska läsa fillen med datan
      public void fileReader() {
          String fileInput = message;
          ArrayList<String> data = new ArrayList<>();
          int i = 0;
          try {
              File input = new File(fileInput);
              Scanner reader = new Scanner(input);
              while (reader.hasNextLine()) {
                  data.add(reader.nextLine());
                  i += 1;
              }
              reader.close();
          } catch (FileNotFoundException e) {
              System.out.println("Ingen file eller kunde inte läsa file");
              e.printStackTrace();
          }
          System.out.println("tog i mot data");
          row = i;
          Object[] tmp = data.toArray();
          String[] tmp2 = new String[tmp.length];
          for (int j = 0 ; j < tmp.length ; j++)
              tmp2[j] = (String)tmp[j];
          crypt_message = tmp2;
      }

      // kalla nyckeln X
      private void inputkey() {
          String fileInput = key;
          String key = null;
          try {
              File input = new File(fileInput);
              Scanner reader = new Scanner(input);
              while (reader.hasNextLine()) {
                  key = reader.nextLine();
              }
              reader.close();

          } catch (FileNotFoundException e) {
              System.out.println("Ingen file eller kunde inte läsa file");
              e.printStackTrace();
          }
          crypt_key = key;
      }

      //krypt med en String (funkar inte med många rader)
      private void cryptSting() {
          fileReader();
          inputkey();
          int messageLength = crypt_message.length;
          String[] svar = new String[messageLength];
          for (int e = 0; e < row; e++){
              String char_svar = "";
              while (crypt_key.length() < crypt_message[e].length()) {
                  crypt_key = expandKey(crypt_key);
              }
              for (int i = 0; i < crypt_message[e].length(); i++) {
                  char_svar += (char) crypt(crypt_message[e].charAt(i), crypt_key.charAt(i));
                  svar[e] = char_svar;
              }
              System.out.println("Medelande krypterad");
              crypt_svar = svar;
          }
      }

      // long nyckel X
      private String expandKey(String crypt_key) {
          return crypt_key + crypt_key;
      }

      // kryptera X
      private int crypt(int m, int k) {
          return m ^ k;
      }

      public static void main(String[] args) {
          String m = "krypt_fill.txt";
          String k = "key.txt";
          String f = "model_fill.txt";

          model cryptModel = new model();
          cryptModel.setMessage(m);
          cryptModel.setKey(k);
          cryptModel.setFile(f);

          cryptModel.cryptSting();
          cryptModel.fileReader();
          cryptModel.makeFile();
          cryptModel.fileOutput();

      }
  }