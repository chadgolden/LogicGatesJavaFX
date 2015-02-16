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
}