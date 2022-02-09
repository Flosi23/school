package dictionary.gui;

import dictionary.Dictionary;
import dictionary.Entry;
import dictionary.Parser;
import dictionary.gui.controller.AdminController;
import dictionary.gui.controller.DictionaryController;
import dictionary.gui.controller.ResultController;
import dictionary.gui.controller.SearchController;
import dictionary.gui.model.AdminModel;
import dictionary.gui.model.ResultModel;
import dictionary.gui.views.AdminView;
import dictionary.gui.views.DictionaryView;
import dictionary.gui.views.ResultView;
import dictionary.gui.views.SearchView;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class StartGUI {


    /**
     * main()-Methode, die die Suchmaschinen-GUI ausführt
     * @param args
     */
    public static void main(String[] args) {
        startGUI();
    }

    public static void startGUI() {
        // Erzeugen einer LinkedDocumentCollection
        Dictionary dictionary = Dictionary.fromCSVFile();

        // Erzeugen der beiden Model-Objekte
        AdminModel adminModel = new AdminModel(dictionary);
        ResultModel resultModel = new ResultModel(dictionary);

        // Erzeugen der SearchEngine-Objekte (View und Controller) und setzen der Referenzen aufeinander
        DictionaryView dictionaryView = new DictionaryView();
        DictionaryController dictionaryController = new DictionaryController();

        dictionaryView.setDictionaryController(dictionaryController);
        dictionaryController.setDictionaryView(dictionaryView);

        // Erzeugen der Admin-Objekte und setzen der Referenzen
        AdminView adminView = new AdminView();
        AdminController adminController = new AdminController();

        adminView.setAdminController(adminController);
        adminController.setAdminView(adminView);
        adminController.setAdminModel(adminModel);

        // Erzeugen der Result-Objekte und setzen der Referenzen
        ResultView resultView = new ResultView();
        ResultController resultController = new ResultController();

        resultView.setResultController(resultController);
        resultController.setResultView(resultView);
        resultController.setResultModel(resultModel);

        // Erzeugen der Search-Objekte und setzen der Referenzen
        SearchView searchView = new SearchView();
        SearchController searchController = new SearchController(dictionaryController);

        searchView.setSearchController(searchController);
        searchController.setSearchView(searchView);

        // Initialisierung der SearchEngineView (+ Setzen weiterer Referenzen auf die speziellen Views)
        dictionaryView.init(dictionaryController, adminView, resultView, searchView);
        dictionaryController.setAdminController(adminController);
        dictionaryController.setResultController(resultController);
        dictionaryController.setSearchController(searchController);

        // Sichtbar-Setzen des Haupt-Frames 'searchEngineView'
        dictionaryView.setSize(700, 600);
        dictionaryView.setVisible(true);
        dictionaryView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
