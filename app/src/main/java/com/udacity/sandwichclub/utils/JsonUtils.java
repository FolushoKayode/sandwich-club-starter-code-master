package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {


        JSONObject sandwichJson = new JSONObject(json);

        JSONObject name = sandwichJson.getJSONObject("name");
        String mainName = name.getString("mainName");


        JSONArray alsoKnownAsJson = name.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsJson.length(); i++) {
            alsoKnownAs.add(alsoKnownAsJson.getString(i));
        }


        String placeOfOrigin = sandwichJson.getString("placeOfOrigin");

        String description = sandwichJson.getString("description");

        String image = sandwichJson.getString("image");

        JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsJson.length(); i++) {
            ingredients.add(ingredientsJson.getString(i));

        }

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwich;
    }
}