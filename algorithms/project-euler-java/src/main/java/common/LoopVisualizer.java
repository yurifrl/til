package common;

class LoopVisualizer {
    protected int[][] array;
    protected String canvas;

    public LoopVisualizer() {
        array = new int[][]{
            { 0, 0, 0, 0},
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
        };
        canvas = "";
        generate(0, 0);
    }

    public String visualize() {
        return "";
    }

    public void generate(int i, int j) {
        canvas += "{\n";
        for (int x = 0; x < array.length; x++) {
            canvas += "  ";
            canvas += "{ ";
            for (int y = 0; y < array[x].length; y++) {
                int v = 0;
                if (x == i && y == j) {
                    v = 1;
                }
                if (y == 0) {
                    canvas += String.format("[%d]", v);
                } else {
                    canvas += String.format(",[%d]", v);
                }
            }
            canvas += " }\n";
        }
        canvas += "}\n";
    }

    public void print() {
        System.out.print(canvas);
    }

    public void clear() {
        canvas = "";
    }

    public void navigate() {
        for (int x = array.length - 1; x > 0; x--) {
            for (int y = array[x].length - 1; y > 0; y--) {
                clear();
                generate(x,y);
                print();
            }
        }
    }

    public void navigateUp() {
        for (int x = 0; x < array.length - 1; x++) {
            for (int y = 0; y < array[x].length - 1; y++) {
                clear();
                generate(x, y);
                print();
            }
        }
    }
}
