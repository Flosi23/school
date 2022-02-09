package dictionary.gui.views;

import dictionary.gui.controller.DictionaryController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TopBar extends JPanel{

    private JLabel title;

    private JButton addButton;
    private JButton removeButton;
    private JButton toAdminViewButton;
    private JButton toSearchViewButton;
    private JButton exitButton;

    /** Setzt die fünf Attribute dieser Klasse auf neue Objekte des entsprechenden Typs
     *  und fügt den Buttons geeignete ActionListener (Lambdas genügen hier völlig) hinzu.
     *  Zwischen dem Titel und den Buttons ist Platz, d.h. der Titel befindet sich ganz links,
     *  die Buttons ganz rechts in der Top-Bar.
     *
     * @param controller Ein Search Engine Controller (für die Events)
     */
    public TopBar(DictionaryController controller) {
        title = new JLabel("");
        title.setFont(new Font("Sans Serif", Font.PLAIN, 17));

        JPanel buttonRow = new JPanel();
        buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.X_AXIS));

        addButton = new JButton("Eintrag hinzufügen");
        removeButton = new JButton("Eintrag entfernen");
        toAdminViewButton = new JButton("Admin Ansicht");
        toSearchViewButton = new JButton("Zurück zur Suche");
        exitButton = new JButton("Exit");

        addButton.addActionListener(event -> controller.addButtonPressed());
        removeButton.addActionListener(event -> controller.removeButtonPressed());
        toAdminViewButton.addActionListener(event -> controller.changeToAdminView());
        toSearchViewButton.addActionListener(event -> controller.changeToSearchView());
        exitButton.addActionListener(event -> controller.exitButtonPressed());

        buttonRow.add(addButton);
        buttonRow.add(removeButton);
        buttonRow.add(toAdminViewButton);
        buttonRow.add(toSearchViewButton);
        buttonRow.add(exitButton);

        this.setLayout(new BorderLayout());
        this.add(buttonRow, BorderLayout.LINE_END);
        this.add(title, BorderLayout.LINE_START);
        this.setBorder(new EmptyBorder(5,5,5,5));
        this.setVisible(true);
    }

    /** Setzt den Text im title-Feld auf den übergebenen Text.
     *
     * @param titleText Neuer Titel-Text
     */
    public void setTitle(String titleText) {
        title.setText(titleText);
    }

    /** Setzt den dem Methodennamen entsprechenden Button unsichtbar.
     */
    public void hideAddButton() {
        addButton.setVisible(false);
    }

    public void showAddButton(){
        addButton.setVisible(true);
    }

    public void hideRemoveButton(){
        removeButton.setVisible(false);
    }

    public void showRemoveButton(){
        removeButton.setVisible(true);
    }

    public void hideToAdminViewButton() {
        toAdminViewButton.setVisible(false);
    }

    public void hideToSearchViewButton() {
        toSearchViewButton.setVisible(false);
    }

    public void showToAdminViewButton(){
        toAdminViewButton.setVisible(true);
    }

    public  void showToSearchViewButton(){
        toSearchViewButton.setVisible(true);
    }
}
