package popcornnight.mati.com.popcornnight.db_package;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLHelper extends SQLiteOpenHelper {


    public SQLHelper(Context context ) {
        super(context, "popcorn_night.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql="CREATE TABLE "+DBConstances.MOVIES_TABLE+" ("+ DBConstances.MOVIES_ID_COLUMN +" INTEGER PRIMARY KEY AUTOINCREMENT, "+DBConstances.MOVIES_TITLE_COLUMN+" TEXT, "+DBConstances.MOVIES_BODY_COLUMN+" TEXT,"+DBConstances.MOVIES_RATING_COLUMN+" REAL,"+DBConstances.MOVIES_IMG_URL_COLUMN +" TEXT )";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
