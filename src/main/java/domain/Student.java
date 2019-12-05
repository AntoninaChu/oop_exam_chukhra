package domain;

import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    private JsonObject stud;
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        // ToDo
        this.stud = new BasicStudent(name, surname, year).toJsonObject();
    }

    public JsonObject toJsonObject() {
        // ToDo
        return null;
    }
}
