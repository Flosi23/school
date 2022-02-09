package dictionary.gui.controller;

import dictionary.gui.views.AddDialog;
import dictionary.gui.views.DictionaryView;
import dictionary.gui.views.RemoveDialog;

import java.awt.event.WindowEvent;

public class DictionaryController {

    private SearchController searchController;
    private ResultController resultController;
    private AdminController adminController;

    private DictionaryView dictionaryView;

    public void setDictionaryView(DictionaryView dictionaryView) {
        this.dictionaryView = dictionaryView;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void setResultController(ResultController resultController) {
        this.resultController = resultController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void processQuery(String query){
        resultController.loadResultsFor(query);
        changeToResultView();
    }

    public void changeToAdminView(){
        adminController.loadEntries();
        dictionaryView.displayAdminView();
    }

    public void changeToResultView(){
        dictionaryView.displayResultView();
    }

    public void changeToSearchView(){
        dictionaryView.displaySearchView();
    }

    public void addButtonPressed(){
        new AddDialog(adminController);
    }

    public void removeButtonPressed(){
        new RemoveDialog(adminController);
    }

    public void exitButtonPressed(){
        dictionaryView.dispatchEvent(new WindowEvent(dictionaryView, WindowEvent.WINDOW_CLOSING));
    }
}
