package InputValidation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author vlad
 */
public class SetValueType {
    public void Controller(JTextField text)
    {
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char CharName = e.getKeyChar();
                if (!Character.isDigit(CharName)) e.consume();
            }
        });

    }
}
