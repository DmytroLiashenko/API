package data;

public enum Curency {
    CAD("cad"),
    EUR("eur"),
    USD("usd");
    String curency;

    Curency(String curency) {
        this.curency = curency;
    }

    public String getCurency() {
        return curency;
    }
}