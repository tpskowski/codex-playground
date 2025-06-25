package com.example.dice;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

public class App {

    public static void main(String[] args) {
        HTMLDocument document = Window.current().getDocument();
        HTMLElement button = document.getElementById("calc-button");
        button.addEventListener("click", evt -> runCalculation());
    }

    private static void runCalculation() {
        HTMLDocument document = Window.current().getDocument();
        int dice = getInputValue("dice-count");
        int level = getInputValue("wizard-level");
        int target = getInputValue("target-value");
        ResultPercentages result = SpellCastingCalculator.calculate(dice, level, target);
        HTMLElement table = document.getElementById("results-body");
        table.setInnerHTML("<tr><td>Miscast</td><td>" + format(result.getMiscast()) + "%</td></tr>" +
                "<tr><td>Irresistible Force</td><td>" + format(result.getIrresistible()) + "%</td></tr>" +
                "<tr><td>Success</td><td>" + format(result.getSuccess()) + "%</td></tr>" +
                "<tr><td>Fail</td><td>" + format(result.getFail()) + "%</td></tr>");
    }

    private static int getInputValue(String id) {
        HTMLDocument document = Window.current().getDocument();
        return Integer.parseInt(document.getElementById(id).getAttribute("value"));
    }

    private static String format(double value) {
        return String.format("%.2f", value);
    }
}
