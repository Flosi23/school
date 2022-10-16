package dictionary.gui.views;

import dictionary.gui.controller.ResultController;

import javax.swing.*;
import java.awt.*;

public class ResultView extends JScrollPane{

    private ResultController resultController;
    private JPanel resultsContainer;

    public ResultView(){
        super();

        JPanel resultsContainerCentered = new JPanel();
        resultsContainerCentered.setLayout(new GridBagLayout());
        this.resultsContainer = new JPanel();
        resultsContainer.setLayout(new BoxLayout(resultsContainer, BoxLayout.Y_AXIS));
        resultsContainerCentered.add(resultsContainer);

        JPanel viewContainer = new JPanel();
        viewContainer.setLayout(new BorderLayout());
        this.setViewportView(viewContainer);

        viewContainer.add(resultsContainerCentered, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setResultController(ResultController resultController) {
        this.resultController = resultController;
    }

    public void addEntryPanel(EntryPanel entryPanel){
        resultsContainer.add(entryPanel);
    }

    public void clear(){
        this.resultsContainer.removeAll();
    }
}
