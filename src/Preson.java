import java.util.Random;

public class Preson {
    protected int x, y;
    private static String image = "ГГ";
    private static int live = 3;
    Random r = new Random();

    Preson(int sizeBoard) {
        y = sizeBoard;
        int n = r.nextInt(sizeBoard);
        x = n == 0 ? 1 : n;
    }

    Preson(int x, int y){
        this.x = x;
        this.y = y;
    }
    Preson(){
        this(1, 1);
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getLive() {
        return live;
    }

    public static String getImage(){
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean moveCorrect(int x, int y){
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void downLive(){
        live--;
    }
}