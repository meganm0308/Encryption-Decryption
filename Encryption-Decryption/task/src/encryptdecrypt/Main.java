package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        boolean dataIn = false;
        boolean dataOut = false;
        String inputFile = null;
        String outputFile = null;
        String alg = "shift";


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
            if (args[i].contains("-alg")) {
                alg = args[i + 1];
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
                if (alg.equals("shift")) {
                    ChooseMethod choose = new ChooseMethod(new Shifting());
                    if (!dataOut) {
                        System.out.println(choose.processData(data, key));
                    } else {
                        try(FileWriter fileWriter = new FileWriter(outputFile)){
                            fileWriter.write(choose.processData(data, key));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    ChooseMethod choose = new ChooseMethod(new Unicode());
                    if (!dataOut) {
                        System.out.println(choose.processData(data, key));
                    } else {
                        try(FileWriter fileWriter = new FileWriter(outputFile)){
                            fileWriter.write(choose.processData(data, key));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "dec":
                if (alg.equals("shift")) {
                    ChooseMethod choose = new ChooseMethod(new ShiftingDec());
                    if (!dataOut) {
                        System.out.println(choose.processData(data, key));
                    } else {
                        try(FileWriter fileWriter = new FileWriter(outputFile)){
                            fileWriter.write(choose.processData(data, key));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    ChooseMethod choose = new ChooseMethod(new UnicodeDec());
                    if (!dataOut) {
                        System.out.println(choose.processData(data, key));
                    } else {
                        try(FileWriter fileWriter = new FileWriter(outputFile)){
                            fileWriter.write(choose.processData(data, key));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
        }
    }
}
