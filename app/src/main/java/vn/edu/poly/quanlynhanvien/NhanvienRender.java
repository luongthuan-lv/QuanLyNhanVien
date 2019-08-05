package vn.edu.poly.quanlynhanvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NhanvienRender extends SQLiteOpenHelper {

    public static final String TABLE_NAME="nhanvien";
   // public static final String COL_STT="stt";
    public static final String COL_NAME="ten";
    public static final String COL_AGE="ngaysinh";

    public NhanvienRender(Context context){
        super(context,"nhanvien.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+COL_NAME+" TEXT PRIMARY KEY ,"+COL_AGE+" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
