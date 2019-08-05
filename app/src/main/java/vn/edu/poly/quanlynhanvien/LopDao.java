package vn.edu.poly.quanlynhanvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static vn.edu.poly.quanlynhanvien.LopRender.COL_MA;
import static vn.edu.poly.quanlynhanvien.LopRender.COL_NAME;
import static vn.edu.poly.quanlynhanvien.LopRender.TABLE_NAME1;

public class LopDao {
    public LopRender lopRender;

    public LopDao(Context context){
        lopRender=new LopRender(context);

    }
    public long indertLop(Lop lop){
        SQLiteDatabase sqLiteDatabase = lopRender.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_MA,lop.malop);
        contentValues.put(COL_NAME,lop.tenlop);
        long res=sqLiteDatabase.insert(TABLE_NAME1,null,contentValues);
        return res;
    }

    public List<Lop> getAllClass() {
        SQLiteDatabase sqLiteDatabase = lopRender.getReadableDatabase();

        List<Lop> lopList = new ArrayList<>();
        String truyVan = "SELECT * FROM " + TABLE_NAME1;
        Cursor cursor = sqLiteDatabase.rawQuery(truyVan, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Lop lop = new Lop();

                lop.malop = cursor.getString(cursor.getColumnIndex(COL_MA));
                lop.tenlop = cursor.getString(cursor.getColumnIndex(COL_NAME));


                lopList.add(lop);


                cursor.moveToNext();
            }
            cursor.close();

        }

        return lopList;
    }
    public void deleteSudent(String id) {
        // xin quyen
        SQLiteDatabase sqLiteDatabase = lopRender.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME1, COL_MA + "=?", new String[]{id});

    }
}
