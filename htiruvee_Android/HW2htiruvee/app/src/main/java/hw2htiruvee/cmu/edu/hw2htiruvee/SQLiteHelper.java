package hw2htiruvee.cmu.edu.hw2htiruvee;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by haripriya on 6/2/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_Event = "events";
    public static final String DATABASE_NAME = "Event";
    public static final int DATABASE_VERSION = 10;
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_name = "_name";
    public static final String COLUMN_dateTime = "_dateTime";
    public static final String COLUMN_location = "_location";
    private static final String DATABASE_CREATE = "CREATE TABLE " +TABLE_Event+
            "(_id integer primary key autoincrement," +
            "name TEXT, " +
            "dateTime TEXT, location TEXT);";
    /**
     * SQLiteHelper method
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public SQLiteHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }
    public SQLiteHelper (Context context) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    /**
     * On create method
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Event);
        onCreate(db);
    }
}