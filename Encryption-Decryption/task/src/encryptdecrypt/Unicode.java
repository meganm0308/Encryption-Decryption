package encryptdecrypt;

public class Unicode implements Algorithms{
    @Override
    public String process(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            int shiftByKey = text.charAt(i) + key;
            int shift = shiftByKey > 127 ?
                    shiftByKey - 128
                    : shiftByKey;
            sb.append((char) shift);
        }
        return sb.toString();
    }
}
