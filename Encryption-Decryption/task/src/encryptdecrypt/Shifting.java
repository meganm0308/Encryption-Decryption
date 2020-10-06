package encryptdecrypt;

public class Shifting implements Algorithms{

    @Override
    public String process(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 65 && text.charAt(i) <= 90) {
                int shift = text.charAt(i) + key > 90 ?
                        text.charAt(i) + key - 91 + 65
                        : text.charAt(i) + key;
                sb.append((char) shift);
            } else if (text.charAt(i) >= 97 && text.charAt(i) <= 122) {
                int shift = text.charAt(i) + key > 122 ?
                        text.charAt(i) + key - 123 + 97
                        : text.charAt(i) + key;
                sb.append((char) shift);
            } else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }
}
