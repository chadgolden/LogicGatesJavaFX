package com.chadgolden.gates;

/**
 *
 */
public class And extends Gate {

    public And(int inputA, int inputB) {
        super(inputA, inputB);
    }

    public And() {
        super();
    }

    @Override
    public int execute() {
        return (input[0] && input[1]) ? 1 : 0;
    }


    @Override
    public int numberOfInputs() {
        return 2;
    }

    @Override
    public int numberOfOutputs() {
        return 1;
    }

    @Override
    public int[] output() {
        return new int[] {
                (input[0] && input[1]) ? 1 : 0
        };
    }

    @Override
    public String[][] getTruthTable() {
        String[][] retVal = new String[5][3];
        retVal[0] = new String[] {"InputA", "InputB", "="};
        Gate gate;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                gate = new And(i, j);
                retVal[1 + (2*i + j)][0] = String.valueOf(i);
                retVal[1 + (2*i + j)][1] = String.valueOf(j);
                retVal[1 + (2*i + j)][2] = String.valueOf(gate.execute());
            }
        }
        return retVal;
    }
}