import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.*;
import java.util.Scanner;

  public class model {
      private String message;
      private String key;
      private String file;
      private String crypt_svar;



      public void setMessage(String message) {
          this.message = message;
      }

      public void setKey(String key) {
          this.key = key;
      }

      public void setFile(String file) {
          this.file = file;
      }

      public String getCrypt_svar() {
          return crypt_svar;
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
              myWriter.write(crypt_svar);
             //myWriter.write("\n" + svarCrypt);
              myWriter.close();
              System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
          }
      }


      // ska läsa fillen med datan (funkar inte med många rader)
      public String fileReader() {
          String fileInput = message;
          String data = null;
          try {
              File input = new File(fileInput);
              Scanner reader = new Scanner(input);
              while (reader.hasNextLine()) {
                  data = reader.nextLine();

              }
              reader.close();
          } catch (FileNotFoundException e) {
              System.out.println("Ingen file eller kunde inte läsa file");
              e.printStackTrace();
          }
          return data;
      }

      // kalla nyckeln X
      private String key() {
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
          return key;
      }

      //krypt med en String (funkar inte med många rader)
      private void cryptSting() {
          String svar = "";
          while (key.length() < message.length()) {
              key = expandKey(key);
          }
          for (int i = 0; i < message.length(); i++) {
              svar += (char) crypt(message.charAt(i), key.charAt(i));
          }
          crypt_svar = svar;
      }

      // long nyckel X
      private String expandKey(String key) {
          return key + key;
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
          cryptModel.getCrypt_svar();
          cryptModel.makeFile();
          cryptModel.fileOutput();
          System.out.println(cryptModel.getCrypt_svar());

      }
  }