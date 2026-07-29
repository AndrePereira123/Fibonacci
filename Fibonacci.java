import java.util.Scanner;  // Import the Scanner class

class Fibonacci {

    public void main() {
        int n = 0;
        Scanner myScan = new Scanner(System.in); 
        System.out.println("Enter 'n' value for fibonacci sequence:");

        n = myScan.nextInt();
        System.out.printf("Result for fibonacci with n = '%d' is %d", n, fib(n));
    };

    private long fib(int n) {
        if (n >= 3) {
            long tinyFib = 0;
            long bigFib = 1;
            for (int i = 3; i < n; i++) {
                bigFib = tinyFib + bigFib;
                tinyFib = bigFib - tinyFib;
            }
            return tinyFib + bigFib;
        }
        return n == 1 ? 0 : 1;
    };
}// 0 1 1 2 3 5 8 