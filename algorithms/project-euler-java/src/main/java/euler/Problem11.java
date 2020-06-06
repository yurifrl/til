package euler;

public class Problem11 {
    public long first(int m[][]) {
        long largest = 0;
        long product = 0;
        for (int x = 0; x < m.length; x ++) {
            for(int y = 0; y < m[x].length; y++) {
                product = rowRightLens(m, x, y);
                largest = Math.max(product, largest);
                product = collumnRightLens(m, x, y);
                largest = Math.max(product, largest);
                product = diagonalRightLens(m, x, y);
                largest = Math.max(product, largest);
            }
        }
        for (int x = m.length - 1; x > 0; x--) {
            for(int y = m[x].length - 1; y > 0; y--) {
                product = rowLeftLens(m, x, y);
                largest = Math.max(product, largest);
                product = collumnLeftLens(m, x, y);
                largest = Math.max(product, largest);
                product = diagonalLeftLens(m, x, y);
                largest = Math.max(product, largest);
            }
        }
        return largest;
    }
    public long rowRightLens(int m[][], int x, int y) {
        if (x+3 >= m.length) {
            return -1;
        }
        return m[y][x] * m[y][x+1] * m[y][x+2] * m[y][x+3];
    }
    public long collumnRightLens(int m[][], int x, int y) {
        if (y+3 >= m[x].length) {
            return -1;
        }
        return m[y][x] * m[y+1][x] * m[y+2][x] * m[y+3][x];
    }
    public long diagonalRightLens(int m[][], int x, int y) {
        if (x+3 >= m.length) {
            return -1;
        }
        if (y+3 >= m[x].length) {
            return -1;
        }
        return m[y][x] * m[y+1][x+1] * m[y+2][x+2] * m[y+3][x+3];
    }
    // =============================== Left
    public long rowLeftLens(int m[][], int x, int y) {
        if (x-3 < 0) {
            return -1;
        }
        return m[y][x] * m[y][x-1] * m[y][x-2] * m[y][x-3];
    }
    public long collumnLeftLens(int m[][], int x, int y) {
        if (y-3 < 0) {
            return -1;
        }
        return m[y][x] * m[y-1][x] * m[y-2][x] * m[y-3][x];
    }
    public long diagonalLeftLens(int m[][], int x, int y) {
        if (x-3 < 0) {
            return -1;
        }
        if (y-3 < 0) {
            return -1;
        }
        // System.out.println("=====");
        // System.out.printf("x: %d y: %d m: %d \n",x , y, m[y][x]);
        return m[y][x] * m[y-1][x-1] * m[y-2][x-2] * m[y-3][x-3];
    }
    // Second implementation
    public long second(int m[][]) {
        long largest = 0;
        long product = 0;
        // horizontal right
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length - 3; y++) {
                product = m[x][y] * m[x][y + 1] * m[x][y + 2] * m[x][y + 3];
                largest = Math.max(largest, product);
            }
        }
        // horizontal left
        for (int x = 0; x < m.length; x++) {
            for (int y = m[x].length; y > 3; y--) {
                product = m[x][y - 1] * m[x][y - 2] * m[x][y - 3] * m[x][y - 4];
                largest = Math.max(largest, product);
            }
        }
        // vertical right
        for (int x = 0; x < m.length - 3; x++) {
            for (int y = 0; y < m[x].length; y++) {
                product = m[x][y] * m[x + 1][y] * m[x + 2][y] * m[x + 3][y];
                largest = Math.max(largest, product);
            }
        }
        // diagonal right
        for (int x = 0; x < m.length - 3; x++) {
            for (int y = 0; y < m[x].length - 3; y++) {
                product = m[x][y] * m[x + 1][y + 1] * m[x + 2][y + 2] * m[x + 3][y + 3];
                largest = Math.max(largest, product);
            }
        }
        // diagonal left
        for (int x = 0; x < m.length - 3; x++) {
            for (int y = 3; y < m[x].length; y++) {
                // this was what was missing
                product = m[x][y] * m[x + 1][y - 1] * m[x + 2][y - 2] * m[x + 3][y - 3];
                largest = Math.max(largest, product);
            }
        }
        return largest;
    }
}
