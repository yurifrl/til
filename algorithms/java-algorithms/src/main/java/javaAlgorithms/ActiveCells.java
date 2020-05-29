package javaAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class ActiveCells {
    //
    // https://www.geeksforgeeks.org/active-inactive-cells-k-days/
    public List<Integer> cellCompete(int[] cells, int days) {
        // bkp states so you can change it before updating it
        List<Integer> list = new ArrayList<Integer>();
        int size = cells.length;
        for (int i = 0; i < size; i++) {
            list.add(i, cells[i]);
        }
        // Loop trought the days
        while (days-- > 0) {
            list = compete(list, size);
        }

        return list;
    }

    public List<Integer> compete(List<Integer> states, int n) {
        List<Integer> tmp = new ArrayList<Integer>();

        // Solve the edge cases
        // Compare to the original state and safe the change in the buffer
        // Solve by XOR the adjacent house with 0
        // 0 ^ nereste house
        // do the same for the upper and lower bounds
        tmp.add(0, 0 ^ states.get(1));

        // Loop trought the states, ignoring the lower and upper bounds
        for (int i = 1; i <= n - 2; i++) {
            // Solve by XOR the previous and next [n - 1] XOR [n + 1]
            tmp.add(i, states.get(i - 1) ^ states.get(i + 1));
        }

        // After the middle is resolved solve the uppder end
        tmp.add(n - 1, 0 ^ states.get(n - 2));

        return tmp;
    }
}
