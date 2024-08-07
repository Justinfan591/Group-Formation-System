package view.components;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * A text field that only accepts numeric input.
 */
public class NumericTextField extends JTextField {
    private DocumentFilter filter;

    /**
     * Constructs a NumericTextField with a default column size of 10.
     * Sets up a DocumentFilter to allow only numeric input.
     */
    public NumericTextField() {
        super(10);
        filter = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
        ((AbstractDocument) this.getDocument()).setDocumentFilter(filter);
    }

    /**
     * Clears the text field.
     * Temporarily removes the DocumentFilter to ensure the field is cleared.
     */
    public void clear() {
        AbstractDocument doc = (AbstractDocument) this.getDocument();
        doc.setDocumentFilter(null);
        this.setText("");
        doc.setDocumentFilter(filter);
    }

    public void setNumber(String text) {
        if (text.matches("(-?\\d*\\.?\\d+)")) {
            AbstractDocument doc = (AbstractDocument) this.getDocument();
            doc.setDocumentFilter(null);
            this.setText(text);
            doc.setDocumentFilter(filter);
        }
    }
}
