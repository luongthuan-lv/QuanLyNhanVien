package vn.edu.poly.quanlynhanvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static vn.edu.poly.quanlynhanvien.LopRender.COL_MA;
import static vn.edu.poly.quanlynhanvien.LopRender.TABLE_NAME1;
import static vn.edu.poly.quanlynhanvien.NhanvienRender.COL_AGE;
import static vn.edu.poly.quanlynhanvien.NhanvienRender.COL_NAME;
//import static vn.edu.poly.quanlynhanvien.NhanvienRender.COL_STT;
import static vn.edu.poly.quanlynhanvien.NhanvienRender.TABLE_NAME;

public class NhanvienDao {
    public NhanvienRender nhanvienRender;
    public NhanvienDao(Context context){
        nhanvienRender=new NhanvienRender(context);
    }
    public long indertNhanvien(Nhanvien nhanvien){
        SQLiteDatabase sqLiteDatabase = nhanvienRender.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_STT,nhanvien.stt);
        contentValues.put(COL_NAME, nhanvien.ten);
        contentValues.put(COL_AGE, nhanvien.ngaysinh);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return result;
    }
    public List<Nhanvien> getAllStudents() {
        SQLiteDatabase sqLiteDatabase = nhanvienRender.getReadableDatabase();

        List<Nhanvien> studentList = new ArrayList<>();
        String truyVan = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(truyVan, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Nhanvien nhanvien = new Nhanvien();
                //nhanvien.stt=cursor.getInt(cursor.getColumnIndex(COL_STT));
                nhanvien.ten = cursor.getString(cursor.getColumnIndex(COL_NAME));
                nhanvien.ngaysinh = cursor.getString(cursor.getColumnIndex(COL_AGE));


                studentList.add(nhanvien);


                cursor.moveToNext();
            }
            cursor.close();

        }

        return studentList;
    }

    public void deleteSudent(String ten) {
        SQLiteDatabase sqLiteDatabase = nhanvienRender.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, COL_NAME + "=?", new String[]{ten});

    }
}
