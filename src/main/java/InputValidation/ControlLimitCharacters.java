package InputValidation;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author vlad
 */
public class ControlLimitCharacters extends PlainDocument {
    private final int maxCharacters;

    public ControlLimitCharacters(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= maxCharacters) {
            super.insertString(offset, str, attr);
        }
    }
}
