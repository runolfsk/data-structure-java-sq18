public class OffByN implements CharacterComparator{
    private int Num = 0;
    public OffByN(int N) {
        Num = N;
    }

    @Override
    public boolean equalChars(char x,char y) {
        return (Math.abs(x - y) == Num);
    }
}
