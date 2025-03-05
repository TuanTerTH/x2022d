package dungtt.xocdia2022.mEnum;

public enum TypeInternet {
    INTERNET_OFF(0, "K"),
    INTERNET_ONLINE(1, "C"),
    OPEN_RULE(2, "Y");
    
    private int key;
    private String value;

    private TypeInternet(int i, String str) {
        this.key = i;
        this.value = str;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
