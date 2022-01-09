package me.giraffetree.gameoflife;

/**
 * 默认规则:
 * 任何少于两个活邻居的活细胞都会死亡，好像是由于人口不足造成的。
 * 任何有超过三个活邻居的活细胞都会死亡，就好像过度拥挤一样。
 * 任何有两三个活邻居的活细胞都可以活到下一代。
 * 任何只有三个活邻居的死细胞都会成为活细胞。
 *
 * @author GiraffeTree
 * @date 2022-01-09
 */
public class LifeTransfer {

    /**
     * 是否变化
     *
     * @param earth 原始
     * @return 是否变化
     */
    public static boolean next(EarthDTO earth) {
        return transfer(earth);
    }

    private static boolean transfer(EarthDTO earth) {
        boolean[][] data = earth.getData();
        int lines = data.length;
        int columns = data[0].length;
        byte[][] aroundSize = getAroundSize(data);
        boolean changed = false;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                byte curAroundSize = aroundSize[i][j];
                boolean curState = data[i][j];
                if (curState) {
                    // 如果当前存活
                    if (earth.getMaxAroundSize() < curAroundSize || earth.getMinAroundSize() > curAroundSize) {
                        data[i][j] = false;
                        changed = true;
                    }
                } else {
                    // 如果当前节点不存在生命
                    if (earth.getNewLifeMaxAroundSize() >= curAroundSize && earth.getNewLifeMinAroundSize() <= curAroundSize) {
                        data[i][j] = true;
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }


    private static byte[][] getAroundSize(boolean[][] array) {
        int lines = array.length;
        int columns = array[0].length;
        byte[][] bytes = new byte[lines][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // 将四周的格子都加上1
                if (array[i][j]) {
                    setAroundExist(bytes, i, j);
                }
            }
        }
        return bytes;
    }

    /**
     * 将某行某列周围 +1
     * 最多8个
     * 假设 (i,j) 在 data 数据集中存在
     *
     * @param data 数据集
     * @param i    某行
     * @param j    某列
     */
    private static void setAroundExist(byte[][] data, int i, int j) {
        int lines = data.length;
        int columns = data[0].length;
        if (i > 0) {
            data[i - 1][j] += 1;
        }
        if (j > 0) {
            data[i][j - 1] += 1;
        }
        if (i > 0 && j > 0) {
            data[i - 1][j - 1] += 1;
        }
        if (lines > i + 1) {
            data[i + 1][j] += 1;
        }
        if (lines > i + 1 && j > 0) {
            data[i + 1][j - 1] += 1;
        }
        if (columns > j + 1) {
            data[i][j + 1] += 1;
        }
        if (columns > j + 1 && i > 0) {
            data[i - 1][j + 1] += 1;
        }
        if (lines > i + 1 && columns > j + 1) {
            data[i + 1][j + 1] += 1;
        }
    }


}
