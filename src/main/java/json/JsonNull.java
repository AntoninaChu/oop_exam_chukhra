package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */

public class JsonNull extends Json {
    private final Object nul;

    public JsonNull(){
        this.nul = null;
    }

    @Override
    public String toJson() {
        // ToDo
        return "null";
    }
}
