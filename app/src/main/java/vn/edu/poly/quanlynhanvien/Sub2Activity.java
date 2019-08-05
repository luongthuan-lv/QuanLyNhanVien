package vn.edu.poly.quanlynhanvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Sub2Activity extends AppCompatActivity {
EditText edtMa,edtTen;
ListView lvListtwo;
private LopDao lopDao;
private LopAdapter lopAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        lvListtwo = findViewById(R.id.lvListtwo);

        lopDao=new LopDao(Sub2Activity.this);
        List<Lop> lopList=lopDao.getAllClass();
        lopAdapter=new LopAdapter(Sub2Activity.this,lopList);
        lvListtwo.setAdapter(lopAdapter);



    }

//    public void ThemLop(View view) {
//
//        lopDao=new LopDao(Sub2Activity.this);
//        String malop = edtMa.getText().toString().trim();
//        String tenlop = edtTen.getText().toString().trim();
//
//        if (malop.equals("")) {
//            Toast.makeText(this, "Vui lòng nhập tên nhân viên!", Toast.LENGTH_SHORT).show();
//        } else if (tenlop.equals("")) {
//            Toast.makeText(this, "Vui lòng ngày sinh nhân viên!", Toast.LENGTH_SHORT).show();
//        } else {
//            Lop lop = new Lop();
//            lop.malop = malop;
//            lop.tenlop = tenlop;
//            long result = lopDao.indertLop(lop);
//
//            List<Lop> lopList=lopDao.getAllClass();
//            lopAdapter = new LopAdapter(Sub2Activity.this,lopList);
//            lvListtwo.setAdapter(lopAdapter);
//
//
//            if (result > 0) {
//
//                Toast.makeText(this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();
//
//            } else {
//
//                Toast.makeText(this, "Thêm Không Thành Công!", Toast.LENGTH_SHORT).show();
//
//            }
//        }
//    }
}
