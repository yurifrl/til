package algs;

import java.util.ArrayList;
import java.util.List;

public class Houses {
    //
    // https://www.geeksforgeeks.org/active-inactive-cells-k-days/
    // Eight houses, represented as cells, are arranged in a straight line.Each day
    // every cell competes with its adjacent
    // cells(neighbors). An integer value of 1 represents an active cell and a value
    // of 0 represents an inactive cell.
    // If the neighbors on both sides of a cell are either active or inactive, the
    // cell becomes inactive on the next day,
    // otherwise the cell becomes active. The two cell on each end have a single a
    // single adjacent cell,
    // so assume that the unoccupied space on the opposite side is an inactive cell.
    // Even after updating the cell state, consider its previous state when updating
    // the state of other cells.
    // The state information of all cells should be updated simultaneously.
    //
    // entry: [ 1, 0, 0, 0, 0, 1, 0, 0]
    // out: [ 0, 1, 0, 0, 1, 0, 1, 0]
    //
    // entry: [ 1, 1, 1, 0, 1, 1, 1, 1]
    // out: [ 0, 0, 0, 0, 0, 1, 1, 0]
    //
    public List<Integer> cellCompete(int[] states, int days) {
        //
        // bkp states so you can change it before updating it
        List<Integer> list = new ArrayList<Integer>();
        int size = states.length;
        int[] tmp = new int[size];
        // Loop trought the days
        while (days-- > 0) {
            tmp = compete(states, size);
            states = tmp.clone();
        }

        for (int i = 0; i < size; i++) {
            list.add(i, states[i]);
        }
        return list;
    }

    public int[] compete(int[] states, int n) {
        int[] tmp = new int[n];

        // Solve the edge cases
        // Compare to the original state and safe the change in the buffer
        // Solve by XOR the adjacent house with 0
        // 0 ^ nereste house
        // do the same for the upper and lower bounds
        tmp[0] = 0 ^ states[1];
        tmp[n - 1] = 0 ^ states[n - 2];
        // Loop trought the states, ignoring the lower and upper bounds
        for (int i = 1; i <= n - 2; i++) {
            // Solve by XOR the previous and next [n - 1] XOR [n + 1]
            tmp[i] = states[i - 1] ^ states[i + 1];
        }

        return tmp;
    }
}
