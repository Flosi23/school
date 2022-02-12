package dictionary.gui.views;

import dictionary.dictionary.Entry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EntryPanel extends JPanel {

    private static final int MAX_CHARS = 30;

    public EntryPanel(Entry e){
        JPanel paddingContainer = new JPanel();
        paddingContainer.setLayout(new BoxLayout(paddingContainer, BoxLayout.PAGE_AXIS));

        Font font = new Font("Sans Serif", Font.PLAIN, 14);

        JLabel foreignLabel = new JLabel();
        foreignLabel.setFont(font);
        JLabel translationLabel = new JLabel();
        translationLabel.setFont(font);
        JLabel explanationLabel = new JLabel();
        explanationLabel.setFont(font);

        foreignLabel.setText(Entry.getForeignLanguage() + ": " + e.getForeignWord());
        translationLabel.setText(Entry.getTranslationLanguage() + ": " + e.getTranslation());
        explanationLabel.setText(Entry.getExplanationString() + ": " + e.getExplanation());

        paddingContainer.add(foreignLabel);
        paddingContainer.add(translationLabel);
        paddingContainer.add(explanationLabel);

        JPanel borderContainer = new JPanel();
        borderContainer.add(paddingContainer);
        borderContainer.setBorder(new LineBorder(Color.BLUE, 1));

        add(borderContainer);
        setBorder(new EmptyBorder(5,0,5,0));
    }

}
