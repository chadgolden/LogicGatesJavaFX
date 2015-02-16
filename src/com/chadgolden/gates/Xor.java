package com.chadgolden.gates;

/**
 * Created by Chad on 2/11/2015.
 */
public class Xor extends Gate {

    public Xor(int inputA, int inputB) {
        super(inputA, inputB);
    }

    public Xor() {
        super();
    }

    @Override
    public int execute() {
        return (input[0] ^ input[1]) ? 1 : 0;
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
                (input[0] ^ input[1]) ? 1 : 0
        };
    }

}