package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws Exception {


        JSONObject sandwichReader = new JSONObject(json);
        JSONObject name = sandwichReader.getJSONObject("name");
        String mainName = name.getString("mainName");

        JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = new ArrayList<>();

        if (alsoKnownAsArray.length() != 0){
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsArray.getString(i));
            }
        }

        String description = sandwichReader.getString("description");
        String placeOfOrigin = sandwichReader.getString("placeOfOrigin");
        String image = sandwichReader.getString("image");

        JSONArray ingredientsArray = sandwichReader.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<>();

        if (ingredientsArray.length() != 0) {
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
            }
        }

        Sandwich sandwich = new Sandwich (mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        return sandwich;
    }

}
