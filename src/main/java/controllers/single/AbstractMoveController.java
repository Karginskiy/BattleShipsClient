package controllers.single;

import models.Field;

abstract class AbstractMoveController {

    final protected Field field;

    AbstractMoveController(Field field) {
        this.field = field;
    }

    abstract boolean shot();
}
