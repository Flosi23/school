package dictionary.gui.views;

import dictionary.gui.controller.DictionaryController;

import javax.swing.*;
import java.awt.*;

public class DictionaryView extends JFrame {

    private DictionaryController dictionaryController;

    private JPanel body;
    private TopBar topBar;

    private AdminView adminView;
    private ResultView resultView;
    private SearchView searchView;

    public DictionaryView(){
        super("Dictionary");
    }

    public void setDictionaryController(DictionaryController dictionaryController) {
        this.dictionaryController = dictionaryController;
    }

    public void init(DictionaryController dictionaryController, AdminView adminView, ResultView resultView, SearchView searchView){
        this.dictionaryController = dictionaryController;
        this.dictionaryController.setDictionaryView(this);
        this.adminView = adminView;
        this.resultView = resultView;
        this.searchView = searchView;

        body = new JPanel();
        body.setLayout(new CardLayout());
        body.add("search", searchView);
        body.add("admin", adminView);
        body.add("result", resultView);

        topBar = new TopBar(dictionaryController);

        this.displaySearchView();
        this.setLayout(new BorderLayout());
        this.add(topBar, "North");
        this.add(body);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /** Diese drei Methoden zeigen die dem Namen entsprechende View an.
     *  Dabei wird der Titel in der Top-Bar korrekt gesetzt und die Buttons in ihr, die in dieser View nicht angezeigt
     *  werden sollen, werden versteckt.
     */
    public void displayAdminView() {
        topBar.setTitle("Admin Ansicht");
        topBar.hideToAdminViewButton();
        topBar.showToSearchViewButton();
        topBar.showToSearchViewButton();
        topBar.showAddButton();
        topBar.showRemoveButton();

        CardLayout bodyLayout = (CardLayout) body.getLayout();
        bodyLayout.show(body, "admin");
    }

    public void displayResultView() {
        topBar.setTitle("Suchresultate");
        topBar.hideAddButton();
        topBar.hideRemoveButton();
        topBar.showToAdminViewButton();
        topBar.showToSearchViewButton();

        CardLayout bodyLayout = (CardLayout) body.getLayout();
        bodyLayout.show(body, "result");
    }

    public void displaySearchView() {
        topBar.setTitle("Suche");
        topBar.hideRemoveButton();
        topBar.hideAddButton();
        topBar.hideToSearchViewButton();
        topBar.showToAdminViewButton();

        CardLayout bodyLayout = (CardLayout) body.getLayout();
        bodyLayout.show(body, "search");
    }
}
