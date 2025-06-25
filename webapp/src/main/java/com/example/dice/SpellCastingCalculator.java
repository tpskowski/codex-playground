package com.example.dice;

public class SpellCastingCalculator {

    public static ResultPercentages calculate(int diceCount, int casterLevel, int target) {
        int[] dice = new int[diceCount];
        Counter counter = new Counter();
        iterate(0, diceCount, casterLevel, target, dice, counter);
        double total = Math.pow(6, diceCount);
        return new ResultPercentages(
                counter.miscast * 100.0 / total,
                counter.irresistible * 100.0 / total,
                counter.success * 100.0 / total,
                counter.fail * 100.0 / total);
    }

    private static void iterate(int depth, int diceCount, int casterLevel, int target, int[] dice, Counter counter) {
        if (depth == diceCount) {
            evaluate(dice, casterLevel, target, counter);
            return;
        }
        for (int face = 1; face <= 6; face++) {
            dice[depth] = face;
            iterate(depth + 1, diceCount, casterLevel, target, dice, counter);
        }
    }

    private static void evaluate(int[] dice, int casterLevel, int target, Counter counter) {
        int sum = casterLevel;
        int ones = 0;
        int sixes = 0;
        for (int die : dice) {
            sum += die;
            if (die == 1) ones++;
            if (die == 6) sixes++;
        }
        if (sixes >= 2) {
            counter.irresistible++;
        } else if (ones >= 2) {
            counter.miscast++;
        } else if (sum >= target) {
            counter.success++;
        } else {
            counter.fail++;
        }
    }

    private static class Counter {
        int miscast;
        int irresistible;
        int success;
        int fail;
    }
}
