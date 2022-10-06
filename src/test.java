public class test {
    public static void main(String[] args) {
        String m = "hej på dig";
        String k = "12371235";

        test crypModel = new test();
        System.out.println(crypModel.crypSting(m,k));
        String x = (crypModel.crypSting(m,k));
        System.out.println(crypModel.crypSting(x,k));


    }

    private String crypSting(String message, String key) {
        String svar = "";
        while (key.length() < message.length()){
            key = expandKey(key);
        }
        for (int i = 0; i < message.length(); i++) {
            svar += (char)crypt(message.charAt(i), key.charAt(i));
        }
        return svar;
    }

    private String expandKey(String key) {
        return key+key;
    }
    private int crypt(int m, int k) {
        return m^k;
    }
}
