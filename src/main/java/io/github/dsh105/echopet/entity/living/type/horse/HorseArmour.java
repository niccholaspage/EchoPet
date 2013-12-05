package io.github.dsh105.echopet.entity.living.type.horse;

public enum HorseArmour {

    NONE(Integer.MIN_VALUE),
    IRON(1),
    GOLD(2),
    DIAMOND(3);

    private int id;

    HorseArmour(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}