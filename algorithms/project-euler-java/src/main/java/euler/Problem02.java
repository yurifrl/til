package euler;

// 02. By considering the terms in the Fibonacci sequence whose values do
// not exceed four million, find the sum of the even-valued terms.
// https://adamdrake.com/an-unreasonably-deep-dive-into-project-euler-problem-2.html
// Even Fibonacci numbers
public class Problem02 {
    public int exec(int n) {
        int n1 = 0;
        int n2 = 1;
        int temp = 0;
        int sum = 0;
        while (true) {
          temp = n1;
          n1 = n2;
          n2 = temp + n2;
          if (n2 % 2 == 0) {
            sum += n2;
          }
          if (n2 >= n) {
            break;
          }
        }
        return sum;
    }
}