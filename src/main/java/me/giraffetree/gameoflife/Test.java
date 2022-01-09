package me.giraffetree.gameoflife;

/**
 * @author GiraffeTree
 * @date 2022-01-09
 */
public class Test {

    public static void main(String[] args) {

        EarthDTO earth = EarthGenerator.getWithRandomLife(3, 3);
        System.out.println("earth generate....");
        System.out.println(Printer.getPrintString(earth.getData()));
        System.out.println("earth generate .... success");

        while (true) {
            System.out.println("\n\t\t------------------\n\n");
            boolean changed = LifeTransfer.next(earth);
            if (!changed) {
                break;
            }
            System.out.println(Printer.getPrintString(earth.getData()));
        }


    }

}
