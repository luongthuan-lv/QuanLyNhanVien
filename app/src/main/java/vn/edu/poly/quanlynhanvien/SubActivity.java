package vn.edu.poly.quanlynhanvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {
    EditText edtTennv, edtNgaysinh;
    Button btnThemsv;
    ListView lvList;
    private NhanvienDao nhanvienDao;
    private NhanvienAdapter nhanvienAdapter;
    private AppCompatSpinner spLop;
    private LopDao lopDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //final List<Lop> lopList=new ArrayList<>();

        edtTennv = findViewById(R.id.edtTennv);
        edtNgaysinh = findViewById(R.id.edtNgaysinh);
        lvList = findViewById(R.id.lvList);
        spLop=findViewById(R.id.spLop);

        nhanvienDao=new NhanvienDao(SubActivity.this);
        List<Nhanvien> nhanvienList=nhanvienDao.getAllStudents();
        nhanvienAdapter = new NhanvienAdapter(SubActivity.this,nhanvienList);
        lvList.setAdapter(nhanvienAdapter);




        lopDao=new LopDao(SubActivity.this);
        final List<Lop> lopList=lopDao.getAllClass();
        MySpinerAdapter mySpinerAdapter=new MySpinerAdapter(SubActivity.this,lopList);
        spLop.setAdapter(mySpinerAdapter);
        Lop lopFake=new Lop();
        //lopFake.malop="-1";
        lopFake.tenlop="ShowAll";
        lopList.add(0,lopFake);

        spLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Lop lop=lopList.get(position);
                if (lop.tenlop.equals("ShowAll")) {
                    Toast.makeText(SubActivity.this,"Vui lòng chọn lớp",Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(SubActivity.this,lop.malop,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }

    public void ThemNhanVien(View view) {

        nhanvienDao=new NhanvienDao(SubActivity.this);
        String ten = edtTennv.getText().toString().trim();
        String ngaysinh = edtNgaysinh.getText().toString().trim();

        if (ten.equals("")) {
            Toast.makeText(this, "Vui lòng nhập tên nhân viên!", Toast.LENGTH_SHORT).show();
        } else if (ngaysinh.equals("")) {
            Toast.makeText(this, "Vui lòng ngày sinh nhân viên!", Toast.LENGTH_SHORT).show();
        } else {
            Nhanvien nhanvien = new Nhanvien();
            nhanvien.ten = ten;
            nhanvien.ngaysinh = ngaysinh;
            long result = nhanvienDao.indertNhanvien(nhanvien);

            List<Nhanvien> nhanvienList=nhanvienDao.getAllStudents();
            nhanvienAdapter = new NhanvienAdapter(SubActivity.this,nhanvienList);
            lvList.setAdapter(nhanvienAdapter);
            edtTennv.setText("");
            edtNgaysinh.setText("");


            if (result > 0) {

                Toast.makeText(this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Thêm Không Thành Công!", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
