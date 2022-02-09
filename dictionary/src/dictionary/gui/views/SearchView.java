package dictionary.gui.views;

import dictionary.gui.controller.SearchController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchView extends JPanel implements ActionListener {

    private SearchController searchController;

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    private JTextField textField;

    /** Erzeugt
     *   1. Den Text "PinguPinguLos" in einer großen, fetten Schrift über den beiden anderen Komponenten.
     *   2. Ein Text-Feld, in das man Suchanfragen eingeben kann.
     *   3. Rechts neben 2. einen Search-Button, auf dessen Klick hin die Suche mit dem aktuell in 2. stehenden
     *      String abgeschickt wird.
     */
    public SearchView() {
        JPanel bigContainer = new JPanel();
        bigContainer.setLayout(new GridLayout(2, 1));

        JLabel headerLabel = new JLabel("Wörterbuch");
        headerLabel.setFont(new Font("Sans Serif", Font.BOLD, 36));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,60));
        textField.setFont(new Font("Sans Serif", Font.PLAIN, 20));

        JButton searchButton = new JButton("Suchen");
        searchButton.setPreferredSize(new Dimension(100,60));
        searchButton.addActionListener(this);

        JPanel container = new JPanel();

        container.setLayout(new FlowLayout());
        container.add(textField);
        container.add(searchButton);

        bigContainer.add(headerLabel);
        bigContainer.add(container);
        bigContainer.setMaximumSize(bigContainer.getPreferredSize());

        this.setLayout(new GridBagLayout());
        this.add(bigContainer, new GridBagConstraints());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = textField.getText();
        searchController.executeSearch(query);
    }
}
