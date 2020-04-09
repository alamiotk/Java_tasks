package CalculatorApp;

public class Equations {
    private String readable;
    private String shortParser;
    private int cursorInside;

    public Equations(String readable, String shortParser, int cursorInside) {
        this.readable = readable;
        this.shortParser = shortParser;
        this.cursorInside = cursorInside;
    }

    public String getReadableName() {
        return readable;
    }

    public String getShortParser() {
        return shortParser;
    }


    public int getCursorInside() {
        return cursorInside;
    }

    @Override
    public String toString() {
        return readable;
    }
}
