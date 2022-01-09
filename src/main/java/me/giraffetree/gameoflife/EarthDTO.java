package me.giraffetree.gameoflife;

import lombok.Data;
import lombok.Getter;

/**
 *
 * @author GiraffeTree
 * @date 2022-01-09
 */
@Data
public class EarthDTO {

    private boolean[][] data;
    private byte minAroundSize;
    private byte maxAroundSize;
    private byte newLifeMinAroundSize;
    private byte newLifeMaxAroundSize;

    public EarthDTO(boolean[][] data) {
        this.data = data;
        this.minAroundSize = 2;
        this.maxAroundSize = 3;
        this.newLifeMinAroundSize = 3;
        this.newLifeMaxAroundSize = 3;
    }

    public EarthDTO(boolean[][] data, byte minAroundSize, byte maxAroundSize, byte newLifeMinAroundSize, byte newLifeMaxAroundSize) {
        this.data = data;
        this.minAroundSize = minAroundSize;
        this.maxAroundSize = maxAroundSize;
        this.newLifeMinAroundSize = newLifeMinAroundSize;
        this.newLifeMaxAroundSize = newLifeMaxAroundSize;
    }

    public boolean[][] getData() {
        return data;
    }

    public void setData(boolean[][] data) {
        this.data = data;
    }

    public byte getMinAroundSize() {
        return minAroundSize;
    }

    public void setMinAroundSize(byte minAroundSize) {
        this.minAroundSize = minAroundSize;
    }

    public byte getMaxAroundSize() {
        return maxAroundSize;
    }

    public void setMaxAroundSize(byte maxAroundSize) {
        this.maxAroundSize = maxAroundSize;
    }

    public byte getNewLifeMinAroundSize() {
        return newLifeMinAroundSize;
    }

    public void setNewLifeMinAroundSize(byte newLifeMinAroundSize) {
        this.newLifeMinAroundSize = newLifeMinAroundSize;
    }

    public byte getNewLifeMaxAroundSize() {
        return newLifeMaxAroundSize;
    }

    public void setNewLifeMaxAroundSize(byte newLifeMaxAroundSize) {
        this.newLifeMaxAroundSize = newLifeMaxAroundSize;
    }
}
