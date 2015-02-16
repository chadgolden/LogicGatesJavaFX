package com.chadgolden.circuits;

import com.chadgolden.gates.*;

/**
 * Creates a circuit when passed its name.
 */
public class LogicFactory {

    /**
     * @param nameOfCircuit
     * @return Requested circuit of all inputs set to 0.
     */
    public Circuit getCircuit(String nameOfCircuit) {
        switch (nameOfCircuit.toUpperCase()) {
            case "NOT":
                return new Not();
            case "OR":
                return new Or();
            case "AND":
                return new And();
            case "XOR":
                return new Xor();
            case "HALF-ADDER":
                return new HalfAdder();
            case "FULL-ADDER":
                return new FullAdder();
        }
        return null;
    }

    /**
     * @param nameOfCircuit
     * @param input Inputs for the circuit.
     * @return Requested circuit of given input.
     * @throws java.lang.ArrayIndexOutOfBoundsException
     */
    public Circuit getCircuit(String nameOfCircuit, int... input) {
        try {
            switch (nameOfCircuit.toUpperCase()) {
                case "NOT":
                    return new Not(input[0]);
                case "OR":
                    return new Or(input[0], input[1]);
                case "AND":
                    return new And(input[0], input[1]);
                case "XOR":
                    return new Xor(input[0], input[1]);
                case "HALF-ADDER":
                    return new HalfAdder(input[0], input[1]);
                case "FULL-ADDER":
                    return new FullAdder(input[0], input[1], input[2]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("com.chadgolden.circuits.LogicFactory getCircuit(String, int...):" +
                    " Wrong length for int...!");
            e.printStackTrace();
        }
        return null;
    }

}
