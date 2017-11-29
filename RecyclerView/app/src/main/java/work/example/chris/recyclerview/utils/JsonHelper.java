package work.example.chris.recyclerview.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import work.example.chris.jsonhelper.common.DataContract;
import work.example.chris.jsonhelper.model.RecordSets;

public class JsonHelper {

    private static final String TAG = JsonHelper.class.getSimpleName();

    private final static String CharSetName = "UTF8";

    public static String getJsonFromRaw(Context context, int resource) {

        String json = "";

        InputStream inputStream;

        inputStream = context.getResources().openRawResource(resource);

        try {
            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            json = new String(buffer, CharSetName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String getJsonFromRaw(Context context) {
        return getJsonFromRaw(context, DataContract.DataResource);
    }

    public static RecordSets getModelFromRaw(Context context) {
        return getModelFromRaw(context, DataContract.DataResource);
    }

    public static RecordSets getModelFromRaw(Context context, int resource) {

        String json = getJsonFromRaw(context, resource);

        Type modelType = new TypeToken<RecordSets>() {
        }.getType();

        return new Gson().fromJson(json, modelType);
    }

}
