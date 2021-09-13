package com.hmtsoft.uniclubz.data.room.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hmtsoft.uniclubz.model.UniversityModel;

import java.lang.reflect.Type;
import java.util.List;

public class UniversityConverter {

    @TypeConverter
    public static List<UniversityModel> fromString(String value) {
        Type listType = new TypeToken<List<UniversityModel>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<UniversityModel> list) {
        return new Gson().toJson(list);

    }
}