package net.heliantum.ziedic.data;

/**
 * Created by Lotos_ on 2016-11-12.
 */


public enum LearningWay {

    POLISH_TO_ENGLISH(0, "z poskiego na angielski"),
    ENGLISH_TO_POLISH(1, "z angielskiego na polski"),
    RANDOM(2, "losowo");

    private int id;
    private String name;

    private LearningWay(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static LearningWay getEnumFromPolish(String name) {
        for(LearningWay way : LearningWay.values()) {
            if(way.getName().equalsIgnoreCase(name)) return way;
        }
        return LearningWay.RANDOM;
    }

    public static LearningWay getEnumFromPolish(int id) {
        for(LearningWay way
                : LearningWay.values()) {
            if(way.getId() == id) return way;
        }
        return LearningWay.RANDOM;
    }


}
