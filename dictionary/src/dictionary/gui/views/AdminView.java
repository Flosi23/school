package dictionary.gui.views;

import dictionary.gui.controller.AdminController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminView extends JScrollPane {

    private AdminController adminController;
    private JPanel resultsContainer;
    private JLabel entriesFound;

    public AdminView(){
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        this.setViewportView(container);
        this.getVerticalScrollBar().setUnitIncrement(10);
        this.getHorizontalScrollBar().setUnitIncrement(10);

        entriesFound = new JLabel();
        entriesFound.setBorder(new EmptyBorder(30,0,20,0));
        entriesFound.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        entriesFound.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(entriesFound, BorderLayout.NORTH);

        JButton loadMoreButton = new JButton("Load More");
        loadMoreButton.addActionListener(event -> adminController.loadNextBatch());
        container.add(loadMoreButton, BorderLayout.SOUTH);

        JPanel resultsContainerCentered = new JPanel();
        resultsContainerCentered.setLayout(new GridBagLayout());
        resultsContainer = new JPanel();
        resultsContainer.setLayout(new BoxLayout(resultsContainer, BoxLayout.Y_AXIS));
        resultsContainerCentered.add(resultsContainer, new GridBagConstraints());
        container.add(resultsContainerCentered);

        this.setVisible(true);
    }

    public void setAdminController(AdminController adminController){
        this.adminController = adminController;
    }

    public void addEntryPanel(EntryPanel entryPanel){
        resultsContainer.add(entryPanel);
    }

    public void clear(){
        resultsContainer.removeAll();
    }

    public void setEntriesFound(int n){
        entriesFound.setText(n + " Einträge gefunden");
    }
}
