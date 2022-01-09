package me.giraffetree.gameoflife;


import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author GiraffeTree
 * @date 2022-01-09
 */
public class PrinterTest {

    @Test
    public void getPrintString() {
        boolean[][] array = new boolean[3][3];
        for (int i = 0; i < array.length; i++) {
            array[i] = new boolean[]{true, false, false};
        }

        String printString = Printer.getPrintString(array);
        System.out.println(printString);
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}