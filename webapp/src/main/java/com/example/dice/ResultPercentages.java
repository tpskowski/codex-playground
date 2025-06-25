package com.example.dice;

public class ResultPercentages {
    private final double miscast;
    private final double irresistible;
    private final double success;
    private final double fail;

    public ResultPercentages(double miscast, double irresistible, double success, double fail) {
        this.miscast = miscast;
        this.irresistible = irresistible;
        this.success = success;
        this.fail = fail;
    }

    public double getMiscast() { return miscast; }
    public double getIrresistible() { return irresistible; }
    public double getSuccess() { return success; }
    public double getFail() { return fail; }
}
