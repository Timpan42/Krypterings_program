package test;

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

    public void cryptString() {
        String result = "";
        while (key.length() < message.length()) {
            key = expandKey(key);
        }
        for (int i = 0 ; i < message.length() ; i++) {
            result += (char)crypt(message.charAt(i), key.charAt(i));
        }
        crypt = result;
    }

    private String expandKey(String key) {
        return key+key;
    }

    private int crypt(int m, int k) {
        return m^k;
    }

    public static void main(String[] args) {
        String m = "HEJ";
        String k = "(((";

        test cryptModel = new test();
        cryptModel.setMessage(m);
        cryptModel.setKey(k);
        cryptModel.cryptString();
        System.out.println(cryptModel.getCrypt());
    }
}