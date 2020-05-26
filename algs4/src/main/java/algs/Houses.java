package algs;

import java.util.ArrayList;
import java.util.List;

public class Houses {
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
    public List<Integer> cellCompete(int[] cells, int days) {
        int n = cells.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = cells[i];
        }

        // Loop trought the days
        while (days-- > 0) {
            // Resolve edge cases
            // match index 0 with index 1 and 0
            tmp[0] = 0 ^ cells[1];
            // match index 7 with index 6 and 0
            tmp[n-1] = 0 ^ cells[n - 2];

            for (int i = 1; i < n - 2; i++) {
                tmp[i] = cells[i - 1] ^ cells[i + 1];
            }

            for (int i = 0; i < n; i++) {
                cells[i] = tmp[i];
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        // maintain the api
        for (int i = 0; i < n; i++) {
            result.add(i, cells[i]);
        }

        return result;
    }
}
