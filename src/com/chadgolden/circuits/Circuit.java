package com.chadgolden.circuits;

/**
 * Created by Chad on 2/14/2015.
 */
public interface Circuit {

    /**
     * @return The number of inputs for the circuit.
     */
    int numberOfInputs();

    /**
     * @return The number of outputs for the circuit.
     */
    int numberOfOutputs();


    /**
     * @return The output of the circuit.
     */
    int[] output();

}