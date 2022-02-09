package dictionary.gui.model;

import dictionary.Dictionary;
import dictionary.Entry;

import java.util.LinkedList;
import java.util.List;

public class ResultModel {

    private final Dictionary dictionary;

    public ResultModel(Dictionary dictionary){
       this.dictionary = dictionary;
    }

    public List<Entry> search(String query){
        Entry entry = dictionary.search(query);
        List<Entry> list = new LinkedList<>();

        if(entry != null){
           list.add(entry);
        }

        return list;
    }
}
