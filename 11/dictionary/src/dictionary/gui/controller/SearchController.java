package dictionary.gui.controller;

import dictionary.gui.views.SearchView;

public class SearchController {

    private DictionaryController mainController;
    private SearchView searchView;

    public SearchController(DictionaryController mainController){
        this.mainController = mainController;
    }

    public void executeSearch(String query){
        mainController.processQuery(query);
    }

    public void setSearchView(SearchView searchView) {
        this.searchView = searchView;
    }
}
