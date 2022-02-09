package dictionary.gui.views;

import dictionary.gui.controller.AdminController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JDialog implements ActionListener {

    AdminController adminController;

    private JTextField foreignWordInput;
    private JTextField translationInput;
    private JTextField explanationInput;

    public AddDialog(AdminController adminController){
        this.setLayout(new BorderLayout());
        this.adminController = adminController;

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4,1));

        JLabel foreignWordLabel = new JLabel("Fremdwort");
        JLabel translationLabel = new JLabel("Übersetzung");
        JLabel explanationLabel = new JLabel("Erklärung");
        foreignWordInput = new JTextField();
        translationInput = new JTextField();
        explanationInput = new JTextField();

        inputPanel.add(foreignWordLabel);
        inputPanel.add(foreignWordInput);
        inputPanel.add(translationLabel);
        inputPanel.add(translationInput);
        inputPanel.add(explanationLabel);
        inputPanel.add(explanationInput);
        inputPanel.setBorder(new EmptyBorder(10,10,0,10));

        JPanel buttonContainerRight = new JPanel();
        buttonContainerRight.setLayout(new BorderLayout());
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new FlowLayout());
        JButton cancelButton = new JButton("Abbrechen");
        JButton addButton = new JButton("Hinzufügen");
        buttonContainer.add(cancelButton);
        buttonContainer.add(addButton);
        buttonContainerRight.add(buttonContainer, BorderLayout.EAST);

        cancelButton.addActionListener(event -> dispose());
        addButton.addActionListener(this);

        this.setPreferredSize(new Dimension(300, 200));
        this.setMinimumSize(this.getPreferredSize());
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonContainerRight, BorderLayout.SOUTH);
        this.setLocationRelativeTo(SwingUtilities.getRootPane(this));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String foreignWord = foreignWordInput.getText();
        String translation = translationInput.getText();
        String explanation = explanationInput.getText();
        adminController.addDialogButtonPressed(foreignWord, translation, explanation);
        dispose();
    }
}
