package frontend.controllers.single;

import frontend.models.Field;

public class HumanMoveController extends AbstractMoveController {

    protected HumanMoveController(Field field) {
        super(field);
    }

    boolean shot() {
        return false;
    }


}
