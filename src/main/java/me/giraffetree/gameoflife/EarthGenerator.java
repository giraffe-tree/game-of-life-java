package me.giraffetree.gameoflife;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GiraffeTree
 * @date 2022-01-09
 */
public class EarthGenerator {

    public static EarthDTO get(int size) {
        boolean[][] data = new boolean[size][size];
        return new EarthDTO(data);
    }

    public static EarthDTO getWithRandomLife(int size, int lifeCount) {
        boolean[][] data = new boolean[size][size];
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < lifeCount; i++) {
            while (true) {
                int l1 = current.nextInt(size);
                int l2 = current.nextInt(size);
                if (data[l1][l2]) {
                    continue;
                }
                data[l1][l2] = true;
                break;
            }
        }
        return new EarthDTO(data);
    }

}
