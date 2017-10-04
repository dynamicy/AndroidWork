package work.example.chris.jsondealer;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class JsonHelper {

    private final static String TAG = JsonHelper.class.getSimpleName();

    public static String getJsonFromAssets(AssetManager assetManager, String filePath) {
        String json = "";
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(filePath);

            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);

            json = new String(buffer, "UTF8");
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
        String json = "";
        InputStream inputStream = null;

        inputStream = context.getResources().openRawResource(R.raw.bill);

        try {
            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            json = new String(buffer, "UTF8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String getJsonFromRaw(Context context, int resource) {
        String json = "";
        InputStream inputStream = null;

        inputStream = context.getResources().openRawResource(resource);

        try {
            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            json = new String(buffer, "UTF8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
