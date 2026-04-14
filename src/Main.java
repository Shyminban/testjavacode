import java.util.Random;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            String castle = "\uD83C\uDFF0";
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
                    int MonsterCounter = size * size - size - 5;
                    Monster[] arrMonster = new Monster[MonsterCounter + 1];
                    int count = 0;
                    Monster monster1;

                    String[][] board = new String[size][size];
                    for (int y = 0; y < size; y++) {
                        for (int x = 0; x < size; x++) {
                            board[y][x] = "  ";
                        }
                    }
                    int castleX = random.nextInt(size);
                    int castleY = 0;

                    board[castleY][castleX] = castle;

                    while (count <= MonsterCounter){
                        if (random.nextBoolean()) {
                            monster1 = new Monster(size);
                        }else if(random.nextBoolean()) {
                            monster1 = new BigMonster(size);
                        }else{
                            monster1 = new MagicMonster(size);
                        }
                        if (board[monster1.getY()][monster1.getX()].equals("  ") && !(castleX == monster1.getX() && castleY == monster1.getY())) {
                            board[monster1.getY()][monster1.getX()] = monster1.getImage();
                            arrMonster[count] = monster1;
                            count++;
                        }
                    }

                    System.out.println("Выбранная сложность:\t" + difficultGame);
                    System.out.println("Размер поля: " + size + "x" + size);
                    System.out.println("Координаты замка: X=" + castleX + ", Y=" + castleY);
                    System.out.println("Количество жизней:\t" + person.getLive() + "\n");
                    System.out.println("Твои кординаты: X=" + personX + ", Y=" + personY);

                    while (true) {
                        board[person.getY() - 1][person.getX() - 1] = person.getImage();
                        outputBoard(board, person.getLive());
                        System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                                "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                        int x = sc.nextInt();
                        int y = sc.nextInt();

                        if (person.moveCorrect(x, y)) {
                            String next = board[y - 1][x - 1];
                            if (next.equals("  ")) {
                                board[person.getY() - 1][person.getX() - 1] = "  ";
                                person.move(x, y);
                                step++;
                                System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                        "\nХод номер: " + step);
                            } else if (next.equals(castle)) {
                                System.out.println("Вы прошли игру!");
                                break;
                            }else {
                                for (Monster monster : arrMonster) {
                                    if (monster.conflictPerson(x, y)) {
                                        if (monster.taskMonster(difficultGame)) {
                                            board[person.getY() - 1][person.getX() - 1] = "  ";
                                            person.move(x, y);

                                        } else {
                                            person.downLive();
                                        }
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Неккоректный ход");
                        }
                    }        break;
            case "НЕТ":
                    System.out.println("Жаль, приходи еще!");
                    break;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
            sc.close();
        }
        static void outputBoard(String[][] board, int live) {
            String leftBlock = "| ";
            String rightBlock = "|";
            String wall = "+ —— + —— + —— + —— + —— +";

            for (String[] raw : board) {
                System.out.println(wall);
                for (String col : raw) {
                    System.out.print(leftBlock + col + " ");
                }
                System.out.println(rightBlock);
            }
            System.out.println(wall);


            System.out.println("Количество жизней:\t" + live + "\n");
        }
    }
