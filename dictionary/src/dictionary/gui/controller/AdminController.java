package dictionary.gui.controller;

import dictionary.Entry;
import dictionary.gui.model.AdminModel;
import dictionary.gui.views.AdminView;
import dictionary.gui.views.EntryPanel;

import java.util.List;

public class AdminController {

    private AdminView adminView;
    private AdminModel adminModel;

    public void setAdminView(AdminView adminView){
        this.adminView = adminView;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public void loadEntries(){
        adminView.clear();
        adminModel.loadListOfAllEntries();
        adminView.setEntriesFound(adminModel.dictionarySize());
        loadNextBatch();
    }

    public void loadNextBatch(){
        loadIntoView(adminModel.getNextBatch());
    }

    public void loadIntoView(List<Entry> entries){
        for(Entry entry: entries){
            EntryPanel entryPanel = new EntryPanel(entry);
            adminView.addEntryPanel(entryPanel);
        }
        adminView.revalidate();
    }

    public void addDialogButtonPressed(String foreignWord, String tranlsation, String explanation){
        adminModel.add(foreignWord, tranlsation, explanation);
        loadEntries();
    }

    public void removeDialogButtonPressed(String removeQuery){
        adminModel.remove(removeQuery);
        loadEntries();
    }
}
