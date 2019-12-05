package json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private List<JsonPair> pairs;
    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        this.pairs = new ArrayList<JsonPair>();
        for(int i = 0; i< jsonPairs.length; i++){
            this.add(jsonPairs[i]);
        }
    }

    @Override
    public String toJson() {
        // ToDo
        String res = "{";
        for(int i =0; i<pairs.size(); i++){
            res += pairs.get(i).key;
            res += ": ";
            res += pairs.get(i).value.toJson();
            if(i != pairs.size() - 1){
                res+=", ";
            }
        }
        res += "}";
        return res;
    }

    public void add(JsonPair jsonPair) {
        // ToDo
        Json val;
        try{
            val = this.find(jsonPair.key);
        } catch (Exception e) {
            pairs.add(jsonPair);
            return;
        }
        if(val == null){
            pairs.add(jsonPair);
        }else {
            for(int i = 0; i < pairs.size(); i++){
                if(pairs.get(i).key == jsonPair.key){
                    pairs.remove(pairs.get(i));
                    pairs.add(jsonPair);
                }
            }
        }
    }

    public Json find(String name) throws Exception {
        // ToDo
        for(int i = 0; i< pairs.size(); i++){
            if(pairs.get(i).key == name){
                return pairs.get(i).value;
            }
        }
        try {
            throw new Exception();
        } finally {
            return null;
        }
    }

    public JsonObject projection(String... names) {
        // ToDo
        JsonObject res = new JsonObject();
        Json value;
        for(int i = 0; i<names.length; i++){
            try {
                value = this.find(names[i]);
                if(value != null) {
                    res.add(new JsonPair(names[i], value));
                }
            } catch (Exception e) {
                continue;
            }
        }
        return res;
    }
}
