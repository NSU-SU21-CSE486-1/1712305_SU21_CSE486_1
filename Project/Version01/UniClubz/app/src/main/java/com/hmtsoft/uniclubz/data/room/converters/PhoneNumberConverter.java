package com.hmtsoft.uniclubz.data.room.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hmtsoft.uniclubz.model.PhoneNumberModel;

import java.lang.reflect.Type;
import java.util.List;

public class PhoneNumberConverter {

    @TypeConverter
    public static List<PhoneNumberModel> fromString(String value) {
        Type type = new TypeToken<List<PhoneNumberModel>>() {
        }.getType();
        return new Gson().fromJson(value, type);
    }

    @TypeConverter
    public static String fromArrayList(List<PhoneNumberModel> list) {
        return new Gson().toJson(list);
    }

}