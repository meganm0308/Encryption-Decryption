package encryptdecrypt;

public class ChooseMethod {
    private Algorithms method;

    public ChooseMethod(Algorithms method) {
        this.method = method;
    }

    public String processData (String text, int key) {
        return method.process(text, key);
    }
}

