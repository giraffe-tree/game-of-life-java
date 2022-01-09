package me.giraffetree.gameoflife;

/**
 * @author GiraffeTree
 * @date 2022-01-09
 */
public class Printer {

    /**
     * 存在生命
     */
    private static final String EXIST_LIFE = "■";
    /**
     * 不存在生命
     */
    private static final String NO_LIFE = "□";

    /**
     * 打印二维数组
     *
     * @param array 数组
     */
    public static String getPrintString(boolean[][] array) {
        StringBuilder sb = new StringBuilder(array.length * array.length);
        for (int i = 0; i < array.length; i++) {
            boolean[] line = array[i];
            for (boolean exist : line) {
                sb.append(exist ? EXIST_LIFE : NO_LIFE);
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
