package work.example.chris.jsondealer.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.model.BillModelSets;

public class JsonHelper {

    private final static String TAG = JsonHelper.class.getSimpleName();

    private final static String CharSetName = "UTF8";

    public static String getJsonFromAssets(AssetManager assetManager, String filePath) {
        String json = "";
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(filePath);

            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);

            json = new String(buffer, CharSetName);
        } catch (IOException ex) {
            Log.e(TAG, "getJsonFromAssets: ", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex1) {
                Log.e(TAG, "getJsonFromAssets: ", ex1);
            }
        }
        return json;
    }

    public static String getJsonFromRaw(Context context) {
        return getJsonFromRaw(context, BillContract.BillResource);
    }

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

    public static BillModelSets getModelFromRaw(Context context, int resource) {

        String json = getJsonFromRaw(context, resource);

        Type modelType = new TypeToken<BillModelSets>() {
        }.getType();

        return new Gson().fromJson(json, modelType);
    }
}
