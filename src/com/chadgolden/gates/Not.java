package com.chadgolden.gates;

/**
 *
 */
public class Not extends Gate {

    public Not(int inputA) {
        super(inputA);
    }

    public Not() {
        super();
    }

    @Override
    public int execute() {
        return (!input[0]) ? 1 : 0;
    }

    @Override
    public int numberOfInputs() {
        return 1;
    }

    @Override
    public int numberOfOutputs() {
        return 1;
    }

    @Override
    public int[] output() {
       return new int[] {
               (!input[0]) ? 1 : 0
       };
    }

}