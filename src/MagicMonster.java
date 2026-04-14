import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;


class MagicMonster extends Monster {
    private String image = "\uD83D\uDC7B";
    private Timer timer = new Timer();
    private volatile boolean timeUp = false;

    public MagicMonster(int size) {
        super(size);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nВремя вышло!");
            }
        }, 10000);
    }

    public boolean taskMonster(int difficultGame) {
        System.out.println("Ты набрёлся на не простого моба...");
        Random random = new Random();

        if (difficultGame == 1) {
            return super.taskMonster(0);
        } else {
            int x = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int z = random.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
            int trueAnswer = x * y - z;

            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
            System.out.println("У тебя есть 10 секунд! А успел ты или нет тайна...");

            timeUp = false;
            startTimer();
            Scanner sc = new Scanner(System.in);
            int ans = 0;

            try {
                ans = sc.nextInt();
                timer.cancel();
                timer = new Timer();
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
                return false;
            }

            if (trueAnswer == ans && !timeUp) {
                System.out.println("Верно! Ты победил монстра и его проклятие");
                return true;
            } else if (timeUp) {
                System.out.println("Ты проиграл эту битву! Время вышло!");
            } else {
                System.out.println("Ты проиграл эту битву!");
            }
            return false;
        }
    }

    public boolean taskMonster() {
        return super.taskMonster(0);
    }
}