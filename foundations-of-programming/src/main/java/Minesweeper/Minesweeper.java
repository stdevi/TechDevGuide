package Minesweeper;


import java.util.*;

public class Minesweeper {
    private int[][] field;

    public void startGame(int rowNum, int colNum, int mineNum) {
        if (mineNum > rowNum * colNum) {
            throw new IllegalArgumentException("The number of mines is larger than the size of the field!");
        }
        field = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                field[i][j] = 0;
            }
        }
        placeMine(rowNum, colNum, mineNum);
    }

    private void placeMine(int rowNum, int colNum, int mineNum) {
        Random r = new Random();
        Set<String> exclude = new HashSet<>();
        int randomMineRow = r.nextInt(rowNum);
        int randomMineColumn = r.nextInt(colNum);

        for (int i = 0; i < mineNum; i++) {
            String mineStringCoordinates = randomMineRow + "" + randomMineColumn;
            while (exclude.contains(mineStringCoordinates)) {
                randomMineRow = r.nextInt(rowNum);
                randomMineColumn = r.nextInt(colNum);
                mineStringCoordinates = randomMineRow + "" + randomMineColumn;
            }
            exclude.add(mineStringCoordinates);
            field[randomMineRow][randomMineColumn] = 9;
            for (int j = Math.max(0, randomMineRow - 1); j <= Math.min(rowNum - 1, randomMineRow + 1); j++) {
                for (int k = Math.max(0, randomMineColumn - 1); k <= Math.min(colNum - 1, randomMineColumn + 1); k++) {
                    if (field[j][k] != 9)
                        field[j][k]++;
                }
            }
        }
    }

    private void printField() {
        for (int[] ints : field) {
            System.out.println(Arrays.toString(ints));
        }
    }
}