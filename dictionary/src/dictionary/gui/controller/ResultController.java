package dictionary.gui.controller;

import dictionary.dictionary.Entry;
import dictionary.gui.model.ResultModel;
import dictionary.gui.views.EntryPanel;
import dictionary.gui.views.ResultView;

import java.util.List;

public class ResultController {

    private ResultView resultView;
    private ResultModel resultModel;

    public void setResultModel(ResultModel resultModel){
        this.resultModel = resultModel;
    }

    public void setResultView(ResultView resultView){
        this.resultView = resultView;
    }

    public void loadResultsFor(String query){
        resultView.clear();
        List<Entry> results = resultModel.search(query);

        for(Entry entry: results){
            resultView.addEntryPanel(new EntryPanel(entry));
        }
    }
}
