package com.chadgolden.gates;

import com.chadgolden.circuits.Circuit;

/**
 * An abstract logic gate implementation. Constructs a Gate when passed a series of
 * inputted 1s and 0s. If the inputs are not a 1 or 0, an exception will be thrown.
 * Otherwise, the 1s and 0s will be processed as boolean values to perform the logic.
 */
public abstract class Gate implements Circuit {

    protected boolean[] input;

    public Gate() {
        this(0, 0);
    }

    /**
     * Class constructor for Gate. Checks if input contains only 1s and 0s. Converts
     * integer values to boolean values.
     * @param input 1 to n input of 1s and 0s.
     */
    public Gate(int... input) {
        checkForInvalidInput(input);
        initializeInput(input);
    }

    /**
     * @return A 0 or 1 value that reflects the correct logic based on the inputs
     * and gate.
     */
    public abstract int execute();

    /**
     * Checks that input contains only 0s or 1s. Invalid input will throw an
     * exception.
     * @param input
     */
    private void checkForInvalidInput(int... input) {
        for (int i : input) {
            if (i > 1 || i < 0) {
                throw new UnsupportedOperationException("Input must be 0 or 1.");
            }
        }
    }

    /**
     * Initializes the boolean input array from a valid integer array.
     * 0 becomes false and 1 becomes true.
     * @param input
     */
    private void initializeInput(int... input) {
        this.input = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            this.input[i] = (input[i] == 0) ? false : true;
        }
    }

    private int[] getInputAsZero() {
        int[] input = new int[numberOfInputs()];
        for (int i = 0; i < input.length; i++) {
            input[i] = 0;
        }
        return input;
    }

    @Override
    public abstract int numberOfInputs();

    @Override
    public int numberOfOutputs() {
        return 0;
    }

    @Override
    public int[] output() {
        return new int[0];
    }
}