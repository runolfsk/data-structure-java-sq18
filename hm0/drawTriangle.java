public class drawTriangle {
    public static void drawTriangles(int N){
        int i = 0;
        int sum = 0;
        while(sum < N){
            i = 0;
            while(i < sum){
                System.out.print("x");
                i = i + 1;
            }
            System.out.println("x");
            sum = sum + 1;
        }
    }
    public static void main(String[] args) {
        drawTriangles(5);
    }
}
