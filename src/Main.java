import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "ГГ";
        int personLive = 3;
        String monster = "Мо";
        String leftBlock = " | ";
        String rightBlock = " |";

        int step = 0;
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer.toUpperCase()) {
            case "ДА":
                System.out.println("Выбери сложность игры(от 1 до 3):");
                int difficultGame = sc.nextInt();
                sc.nextLine();
                int size = difficultGame + 2;

                int personX = 1;
                int personY = 1;

                int castleX = random.nextInt(size);
                int castleY = random.nextInt(size);

                while (castleX == personX && castleY == personY) {
                    castleX = random.nextInt(size);
                    castleY = random.nextInt(size);
                }

                System.out.println("Выбранная сложность:\t" + difficultGame);
                System.out.println("Размер поля: " + size + "x" + size);
                System.out.println("Координаты замка: X=" + castleX + ", Y=" + castleY);
                System.out.println("Количество жизней:\t" + personLive + "\n");

                while (personLive > 0 && !(castleX == personX && castleY == personY)) {
                    String wall = " +";
                    for (int i = 0; i < size; i++) {
                        wall += " —— +";
                    }

                    System.out.println(wall);
                    for (int y = 0; y < size; y++) {
                        System.out.print(leftBlock);
                        for (int x = 0; x < size; x++) {
                            if (personY == y && personX == x) {
                                System.out.print(person);
                            } else if (castleX == x && castleY == y) {
                                System.out.print("ЗЗ");
                            } else {
                                System.out.print("  ");
                            }
                            System.out.print(rightBlock);
                        }
                        System.out.println();
                        System.out.println(wall);
                    }

                    System.out.println("Введите ход ");

                    int nextX, nextY;
                    try {
                        nextX = sc.nextInt();
                        nextY = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод. Попробуйте снова.");
                        sc.nextLine();
                        continue;
                    }

                    if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                        if (Math.abs(nextX - personX) + Math.abs(nextY - personY) == 1) {
                            personX = nextX;
                            personY = nextY;
                            step++;
                            System.out.println("Ход корректный. Новые координаты: X=" + personX + ", Y=" + personY);
                            System.out.println("Ход номер: " + step);

                            if (personX == castleX && personY == castleY) {
                                System.out.println("\n*** ПОБЕДА! Вы достигли замка! ***");
                            }

                        } else {
                            System.out.println("Неккоректный ход: можно двигаться только на одну клетку по горизонтали или вертикали.");
                        }
                    }


                }
                break;
            case "НЕТ":
                System.out.println("Жаль, приходи еще!");
                break;
            default:
                System.out.println("Неизвестная команда.");
                break;
        }
        sc.close();
    }
}