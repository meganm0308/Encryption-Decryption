package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

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
        boolean dataIn = false;
        boolean dataOut = false;
        String inputFile = null;
        String outputFile = null;


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
            if (args[i].contains("-in")) {
                dataIn = true;
                inputFile = args[i + 1];
            }
            if (args[i].contains("-out")) {
                dataOut = true;
                outputFile = args[i + 1];
            }
        }

        if (dataIn && data.isEmpty()) {
            File file = new File(inputFile);
            StringBuilder fileData = new StringBuilder();
            try(Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    fileData.append(scanner.nextLine());
                }
                data = fileData.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        switch (mode) {
            case "enc":
                if (!dataOut) {
                    System.out.println(encryption(data, key));
                } else {
                    try(FileWriter fileWriter = new FileWriter(outputFile)){
                        fileWriter.write(encryption(data, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "dec":
                if (!dataOut) {
                    System.out.println(decryption(data, key));
                } else {
                    try(FileWriter fileWriter = new FileWriter(outputFile)){
                        fileWriter.write(decryption(data, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
