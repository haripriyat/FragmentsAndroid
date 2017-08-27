package hw2htiruvee.cmu.edu.hw2htiruvee;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haripriya on 6/1/2017.
 */

/**
 * This is a data access object for the event class
 */
public class EventDao {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = { SQLiteHelper.COLUMN_ID,
            SQLiteHelper.COLUMN_name,
            SQLiteHelper.COLUMN_dateTime,
            SQLiteHelper.COLUMN_location };
    public EventDao(Context context) {
        dbHelper = new SQLiteHelper (context,
                SQLiteHelper.DATABASE_NAME, null,
                SQLiteHelper.DATABASE_VERSION);
    }

    /**
     * Open method to open the database
     * @throws SQLException
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    /**
     * Close method to close the database
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * insert method to insert an event into the database
     * @param name
     * @param dateTime
     * @param location
     */
    public void insertEvent(String name, String dateTime, String
            location)
    {
        ContentValues newEvent = new ContentValues();
        newEvent.put("name", name);
        newEvent.put("dateTime", dateTime);
        newEvent.put("location", location);
        open();
        database.insert(SQLiteHelper.TABLE_Event, null, newEvent);
        close();
    }

    /**
     * update event method to update an event in database
     * @param id
     * @param name
     * @param dateTime
     * @param location
     */
    public void updateEvent(long id, String name, String dateTime,
                            String location)
    {
        ContentValues editEvent = new ContentValues();
        editEvent.put("name", name);
        editEvent.put("dateTime", dateTime);
        editEvent.put("location", location);
        open();
        database.update(SQLiteHelper.TABLE_Event, editEvent,
                "_id=" + id, null);
        close();
    }

    /**
     * To getAll eventnames from the database
     * @return
     */
    public Cursor getAllEventNames()
    {
        database = dbHelper.getReadableDatabase();
        return database.query(SQLiteHelper.TABLE_Event, new
                String[] {"_id", "name"}, null, null, null, null, "_id");
    }

    /**
     * To get all event objects from the database
     * @return
     */
    public Cursor getAllEvents()
    {
        database = dbHelper.getReadableDatabase();
        return database.query(SQLiteHelper.TABLE_Event, new
                        String[] {"_id", "name", "dateTime", "location"}, null, null, null,
                null, "_id");
    }

    /**
     * To get All Lists of Events from the database
     * @return
     */
    public List<Event> getAllEventLists() {
        List<Event> events = new ArrayList<Event>();
        Cursor cursor = database.query(SQLiteHelper.TABLE_Event,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Event Event = cursorToEvent(cursor);
            events.add(Event);
            cursor.moveToNext();
        } // make sure to close the cursor
        cursor.close();
        return events;
    }

    /**
     * cursorToEvent method
     * @param cursor
     * @return
     */
    private Event cursorToEvent(Cursor cursor) {
        Event event = new Event();
        event.setName(cursor.getString(1));
        return event;
    }

    /**
     * getOneEvent method
     * @param id
     * @return
     */
    public Cursor getOneEvent(long id)
    {
        database = dbHelper.getReadableDatabase();
        return database.query(SQLiteHelper.TABLE_Event, null,
                "_id=" + id, null, null, null, null);
    }

    /**
     * deleteEvent method
     * @param id
     */
    public void deleteEvent(long id)
    {
        open();
        database.delete(SQLiteHelper.TABLE_Event, "_id=" + id,
                null);
        close();
    }
}