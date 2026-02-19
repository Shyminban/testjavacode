public class 004 {
    public static void 004(String[] args) {
        double x = 2.0; 
        double y = 3.0; 

        double step1 = 1 + y;
        double step2 = x * x - 4;
        double step3 = 1.0 / step2;
        double step4 = y + step3;
        double step5 = (x + y) / step4;
        double step6 = 2 * x + y * y - step5;
        double answer = step1 * step6;

        System.out.println("ответ = " + answer);
    }
}