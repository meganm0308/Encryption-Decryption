package encryptdecrypt;

import java.util.Scanner;

public class Main {
final static Scanner scanner = new Scanner(System.in);

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
        String operation = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();

        if (operation.equals("enc")) {
            System.out.println(encryption(text, key));
        } else {
            System.out.println(decryption(text, key));
        }
    }
}
