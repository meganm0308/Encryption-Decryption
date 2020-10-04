package encryptdecrypt;

public class Main {

private static String encryption (String text, int key) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        int shiftByKey = text.charAt(i) + key;
        int shift = shiftByKey > 127 ?
                shiftByKey - 128
                : shiftByKey;
        sb.append((char) shift);
    }
    return sb.toString();
}

private static String decryption (String encryptedText, int key) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < encryptedText.length(); i++) {
        int shiftByKey = encryptedText.charAt(i) - key;
        int shift = shiftByKey < 0 ?
                shiftByKey + 128
                : shiftByKey;
        sb.append((char) shift);
    }
    return sb.toString();
}
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].contains("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].contains("-data")) {
                data = args[i + 1];
            }
        }
        switch (mode) {
            case "enc":
                System.out.println(encryption(data, key));
                break;
            case "dec":
                System.out.println(decryption(data, key));
                break;
        }
    }
}
