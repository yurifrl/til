package algs;

import java.util.List;
import java.util.ArrayList;

public class Houses {
    // Eight houses, represented as cells, are arranged in a straight line.Each day every cell competes with its adjacent
    // cells(neighbors). An integer value of 1 represents an active cell and a value of 0 represents an inactive cell.
    // If the neighbors on both sides of a cell are either active or inactive, the cell becomes inactive on the next day,
    // otherwise the cell becomes active. The two cell on each end have a single a single adjacent cell,
    // so assume that the unoccupied space on the opposite side is an inactive cell.
    // Even after updating the cell state, consider its previous state when updating the state of other cells.
    // The state information of all cells should be updated simultaneously.
    //
    // entry: [ 1, 0, 0, 0, 0, 1, 0, 0]
    // out:   [ 0, 1, 0, 0, 1, 0, 1, 0]
    //
    // entry: [ 1, 1, 1, 0, 1, 1, 1, 1]
    // out:   [ 0, 0, 0, 0, 0, 1, 1, 0]
    public List<Integer> cellCompete(int[] states, int days) {
        int size = states.length;
        List<Integer> newState = new ArrayList<Integer>();

        while (days-- > 0) {
            // Houses interation
            for (int i = 0; i < size; i++) {
                System.out.println("size: " + newState.size());
                System.out.println("index: " + i);
                // First house
                if (i == 0) {
                    if (i <= newState.size()) {
                        newState.add(i, 0 ^ states[1]);
                    } else {
                        newState.set(i, 0 ^ states[1]);
                    }
                    continue;
                }
                // last state
                if (i == size - 1) {
                    if (i <= newState.size()) {
                        newState.add(i, 0 ^ states[size - 2]);
                    } else {
                        newState.set(i, 0 ^ states[size - 2]);
                    }

                    continue;
                }
                if (i <= newState.size()) {
                    newState.add(i, states[i - 1] ^ states[i + 1]);
                } else {
                    newState.set(i, states[i - 1] ^ states[i + 1]);
                }

                System.out.println("index: " + i);
                System.out.println("value: " + newState.get(i));
            }

        }


        return newState;
    }
}
