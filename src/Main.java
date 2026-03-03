import PACKAGE_NAME.Monster;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String monster = "Мо";
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— +";
        String castle = "ЗЗ";
        int size = 5;

        Preson person = new Preson(size);


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

                int personX = 1;
                int personY = 5;
                int MonsterCounter = size * size - size - 1;
                String[] Monsters = new String[MonsterCounter + 1];

                int castleX = random.nextInt(1, size);
                int castleY = 1;
                String[] board = new String[size * size];
                int count = 0;
                Monster test;
                while (count <= MonsterCounter){
                    Monster Mon;
                    if (random.nextBoolean()) {
                        Mon = new Monster(size);
                    }//else {
                        //Mon = new BigMonster(sizeBoard);
                    //}
                    if (board[Mon.getY()][test.getX()].equals("  ")){
                        board[Mon.getY()][test.getX()] = test.getImage();
                        Monsters[count] = test;
                        count++; // will fix later...
                    }

                }

                System.out.println("Выбранная сложность:\t" + difficultGame);
                System.out.println("Размер поля: " + size + "x" + size);
                System.out.println("Координаты замка: X=" + castleX + ", Y=" + castleY);
                System.out.println("Количество жизней:\t" + Preson.getLive() + "\n");
                System.out.println("Твои кординаты: X=" + personX + ", Y=" + personY);

                while (Preson.getLive() > 0 && !(castleX == personX && castleY == personY)) {

                    for (int y = 1; y <= size; y++) {
                        System.out.println(wall);
                        for (int x = 1; x <= size; x++) {
                            System.out.print(leftBlock);
                            if (personY == y && personX == x) {
                                System.out.print(Preson.getImage());
                            } else if (castleX == x && castleY == y) {
                                System.out.print(castle);
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);

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