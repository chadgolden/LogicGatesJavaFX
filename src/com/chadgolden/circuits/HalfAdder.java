package com.chadgolden.circuits;

import com.chadgolden.gates.*;

/**
 * A Half Adder as defined in the homework page.
 * Created by Chad on 2/11/2015.
 */
public class HalfAdder implements Circuit {

    private Or orGate;
    private And andGate1;
    private And andGate2;
    private Not notGate;

    /**
     * Default class constructor that sets all inputs to 0.
     */
    public HalfAdder() {
        this(0, 0);
    }

    /**
     * Class constructor for HalfAdder that takes two inputs.
     * @param inputA
     * @param inputB
     */
    public HalfAdder(int inputA, int inputB) {
        orGate = new Or(inputA, inputB);
        andGate1 = new And(inputA, inputB);
        notGate = new Not(andGate1.execute());
        andGate2 = new And(orGate.execute(), notGate.execute());
    }

    /**
     * @return output "S" as defined in homework page.
     */
    public int s() {
        return andGate2.execute();
    }

    /**
     * @return Output "S" as defined in the homework page.
     */
    public int c() {
        return andGate1.execute();
    }

    /**
     * Prints the truth table for this definition of HalfAdder to the console.
     */
    public static void printTruthTable() {
        HalfAdder halfAdder;
        System.out.println("-----------------------------");
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                halfAdder = new HalfAdder(i, j);
                System.out.println("a = " + i + ",  b = " + j + ",  s = " + halfAdder.s() + ",  c = " + halfAdder.c());
            }
        }
        System.out.println("-----------------------------");
    }

    @Override
    public int numberOfInputs() {
        return 2;
    }

    @Override
    public int numberOfOutputs() {
        return 2;
    }

    @Override
    public int[] output() {
        return new int[] {
                andGate2.output()[0],
                andGate1.output()[0]
        };
    }

    @Override
    public String[][] getTruthTable() {
        String[][] retVal = new String[(int)Math.pow(2, 2) + 1][4];
        retVal[0] = new String[] {"InputA", "InputB", "S", "C"};
        HalfAdder halfAdder;
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                halfAdder = new HalfAdder(a, b);
                retVal[1 + ((2*a) + (1*b))][0] = String.valueOf(a);
                retVal[1 + ((2*a) + (1*b))][1] = String.valueOf(b);
                retVal[1 + ((2*a) + (1*b))][2] = String.valueOf(halfAdder.s());
                retVal[1 + ((2*a) + (1*b))][3] = String.valueOf(halfAdder.c());
            }
        }
        return retVal;
    }
}