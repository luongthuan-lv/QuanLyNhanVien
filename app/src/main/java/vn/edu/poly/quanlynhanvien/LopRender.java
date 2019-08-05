package vn.edu.poly.quanlynhanvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LopRender extends SQLiteOpenHelper {

    public static final String TABLE_NAME1 = "lop";
    public static final String COL_MA = "malop";
    public static final String COL_NAME = "tenlop";

    public LopRender(Context context) {
        super(context, "lop.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME1 + " ("+COL_MA+" TEXT PRIMARY KEY ,"+COL_NAME+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
