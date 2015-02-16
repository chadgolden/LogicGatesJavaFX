package com.chadgolden.truthtables;

import com.chadgolden.circuits.Circuit;
import com.chadgolden.circuits.LogicFactory;

/**
 * Constructs a circuit's truth table when passed the name of the circuit.
 * TODO: Refactor!
 */
public class TruthTable {

    private String nameOfCircuit;
    private Circuit circuit;

    /**
     * Construct a TruthTable object...
     * @param nameOfCircuit
     */
    public TruthTable(String nameOfCircuit) {
        this.nameOfCircuit = nameOfCircuit;
        circuit = new LogicFactory().getCircuit(nameOfCircuit);
    }

    /**
     * @return The truth table for the circuit. The first row contains the column headers.
     */
    public String[][] getTruthTable() {
        int numberOfRows = 1 + (int)Math.pow(2, circuit.numberOfInputs());
        int numberOfColumns = circuit.numberOfInputs() + circuit.numberOfOutputs();
        String[][] truthTable = new String[numberOfRows][numberOfColumns];
        truthTable[0] = getHeadings();
        for (int i = 1; i < numberOfRows; i++) {
            truthTable[i] = generateBinaryTable()[i - 1];
        }
        return truthTable;
    }

    /**
     * @return A row containing the headers for the columns of the truth tables.
     */
    private String[] getHeadings() {
        String[] headings = new String[circuit.numberOfInputs() + circuit.numberOfOutputs()];
        for (int i = 1; i <= headings.length; i++) {
            headings[i - 1] = (i <= circuit.numberOfInputs()) ? "Input" + i : "Output" + (i - circuit.numberOfInputs());
        }
        return headings;
    }

    /**
     * Return a binary truth table for the circuit.
     * Hack coding... Badly in need of refactoring...
     * @return
     */
    private String[][] generateBinaryTable() {

        String[][] binaryTable =
                new String
                        [1 + (int)Math.pow(2, circuit.numberOfInputs())]
                        [circuit.numberOfInputs() + circuit.numberOfOutputs()];

        switch(circuit.numberOfInputs()) {
            case 1:
                for (int a = 0; a < 2; a++) {
                    circuit = new LogicFactory().getCircuit(nameOfCircuit, a);
                    binaryTable[a][0] = String.valueOf(a);
                    for (int outputColumn = circuit.numberOfInputs();
                         outputColumn < circuit.numberOfInputs() + circuit.numberOfOutputs();
                         outputColumn++) {
                        binaryTable[a][outputColumn] =
                                String.valueOf(circuit.output()[outputColumn - circuit.numberOfInputs()]);
                    }
                }
                return binaryTable;
            case 2:
                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) {
                        circuit = new LogicFactory().getCircuit(nameOfCircuit, a, b);
                        binaryTable[(2*a + b)][0] = String.valueOf(a);
                        binaryTable[(2*a + b)][1] = String.valueOf(b);
                        for (int outputColumn = circuit.numberOfInputs();
                             outputColumn < circuit.numberOfInputs() + circuit.numberOfOutputs();
                             outputColumn++) {
                            binaryTable[(2*a + b)][outputColumn] =
                                    String.valueOf(circuit.output()[outputColumn - circuit.numberOfInputs()]);
                        }
                    }
                }
                return binaryTable;
            case 3:
                for (int a = 0; a < 2; a++) {
                    for (int b = 0; b < 2; b++) {
                        for (int c = 0; c < 2; c++) {
                            circuit = new LogicFactory().getCircuit(nameOfCircuit, a, b, c);
                            binaryTable[((4*a) + (2*b) + c)][0] = String.valueOf(a);
                            binaryTable[((4*a) + (2*b) + c)][1] = String.valueOf(b);
                            binaryTable[((4*a) + (2*b) + c)][2] = String.valueOf(c);
                            for (int outputColumn = circuit.numberOfInputs();
                                 outputColumn < circuit.numberOfInputs() + circuit.numberOfOutputs();
                                 outputColumn++) {
                                    binaryTable[((4*a) + (2*b) + c)][outputColumn] =
                                            String.valueOf(circuit.output()[outputColumn - circuit.numberOfInputs()]);
                            }
                        }
                    }

                }
                return binaryTable;
        }
        return null;
    }

    /**
     * Print this truth table to standard output.
     */
    public void printTruthTable() {
        String[][] truthTable = getTruthTable();
        for (int i = 0; i < truthTable.length; i++) {
            for (int j = 0; j < truthTable[i].length; j++) {
                System.out.print(truthTable[i][j] + " ");
            }
            System.out.println();
        }
    }

}
