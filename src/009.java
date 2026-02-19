import java.util.Scanner;

public class 009 {
    public static void 009(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x: ");
        double x = scanner.nextDouble();
        double y;

        if (x > 2) {
            y = (x * x - 1) / (x + 2);
        } else if (x > 0) {
            y = (x * x - 1) * (x + 2);
        } else {
            y = x * x * (1 + 2 * x);
        }

        System.out.println("y = " + y);
    }
}