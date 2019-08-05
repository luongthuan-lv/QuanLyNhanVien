package vn.edu.poly.quanlynhanvien;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LopDao lopDao;
    private LopAdapter lopAdapter;
    private ListView lvListtwo;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View dialog = LayoutInflater.from(this).inflate(R.layout.my_dialog, null);
        builder.setView(dialog);
        builder.create();
        alertDialog = builder.show();
        final EditText edtTen, edtMa;
        Button btnClear, btnSave;



        edtMa = dialog.findViewById(R.id.edtMa);
        edtTen = dialog.findViewById(R.id.edtTen);
        btnClear = dialog.findViewById(R.id.btnClear);
        btnSave = dialog.findViewById(R.id.btnSave);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMa.setText("");
                edtTen.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lopDao = new LopDao(MainActivity.this);
                String malop = edtMa.getText().toString().trim();
                String tenlop = edtTen.getText().toString().trim();

                if (malop.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên nhân viên!", Toast.LENGTH_SHORT).show();
                } else if (tenlop.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng ngày sinh nhân viên!", Toast.LENGTH_SHORT).show();
                } else {
                    Lop lop = new Lop();
                    lop.malop = malop;
                    lop.tenlop = tenlop;
                    long res = lopDao.indertLop(lop);


                    if (res > 0) {

                        Toast.makeText(MainActivity.this, "Thêm Thành Công!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();

                    } else {

                        Toast.makeText(MainActivity.this, "Thêm Không Thành Công!", Toast.LENGTH_SHORT).show();

                    }
                }
            }


        });


    }
    public void openList (View view){
        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        startActivity(intent);
    }

    public void seeList (View view){
        Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
        startActivity(intent);
    }
}
