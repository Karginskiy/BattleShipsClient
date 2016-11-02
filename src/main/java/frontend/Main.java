package frontend;

import frontend.controllers.single.AIMoveController;
import frontend.models.Field;
import frontend.views.AIPlayerFieldView;

import javax.swing.*;

public class Main extends JFrame {

    private Main() {
        Field aiField = new Field(8);
        AIMoveController aiMoveController = new AIMoveController(aiField);
        setBounds(200, 200, 406, 426);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        add(new AIPlayerFieldView(aiField));
        setVisible(true);
    }

    public static void main(String[] args) {

        new Main();

    }

}
