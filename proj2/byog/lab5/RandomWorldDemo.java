package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world that contains RANDOM tiles.
 */
public class RandomWorldDemo {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    public static class Position {
        private int x;
        private int y;

        public Position(int Position_x,int Position_y) {
            this.x = Position_x;
            this.y = Position_y;
        }
    }



    /**
     * Fills the given 2D array of tiles with RANDOM tiles.
     * @param tiles
     */
    public static void fillWithRandomTiles(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = randomTile();
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.NOTHING;
            default: return Tileset.NOTHING;
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        fillWithRandomTiles(randomTiles);

        ter.renderFrame(randomTiles);
    }

    // 返回size为s的六边形的第i行的宽度，底部为第0行
    public static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (i <= s) {
            return 2 * s - effectiveI - 1;
        }
        else {
            effectiveI = 2 * s - 1 - i;
            return s + 2 * effectiveI;
        }
    }

    //返回尺寸为s的第i行的最左侧的x坐标，假设最底部的那一行的最左侧的x的坐标是0
    public static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i <= s) {
            return -effectiveI;
        }
        else {
            effectiveI = 2 * s -1 - i;
            return -effectiveI;
        }
    }

    //增加一行图案为t的图形
    public static void addRow(TETile[][] world, Position p, int width, TETile t){
        for (int x_i = 0; x_i < width; x_i = x_i + 1) {
            int xCoord = p.x + x_i;
            int yCoord = p.y;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    //向界面中增加一个六边形
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2");
        }

        for(int y_i = 0; y_i < 2 * s; y_i++) {
            int thisRowY = p.y + y_i;
            int xRowStart = p.x + hexRowOffset(s, y_i);
            Position rowStartP = new Position(xRowStart, thisRowY);
            int rowWidth = hexRowWidth(s, y_i);
            addRow(world, rowStartP, rowWidth, t);
        }
    }
}
