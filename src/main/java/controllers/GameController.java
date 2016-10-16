package controllers;

import models.Field;

public class GameController {

    final private Field field;

    public GameController(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

}
