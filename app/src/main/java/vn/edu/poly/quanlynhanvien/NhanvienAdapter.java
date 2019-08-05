package vn.edu.poly.quanlynhanvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class NhanvienAdapter extends BaseAdapter {
    private Context context;
    private List<Nhanvien> nhanvienList;
    private NhanvienDao nhanvienDao;


    public NhanvienAdapter(Context context,List<Nhanvien> nhanvienList){
        this.context=context;
        this.nhanvienList=nhanvienList;
        this.nhanvienDao=new NhanvienDao(context);


    }
    @Override
    public int getCount() {
        return nhanvienList.size();
    }

    @Override
    public Object getItem(int position) {
        return nhanvienList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.ner,parent,false);
        //TextView tvStt=convertView.findViewById(R.id.tvStt);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAge = convertView.findViewById(R.id.tvAge);
        TextView tvStt = convertView.findViewById(R.id.tvStt);



        final Nhanvien nhanvien = (Nhanvien) getItem(position);
        tvName.setText("Name : " +nhanvien.ten);
        tvAge.setText("Date : "+nhanvien.ngaysinh);
        tvStt.setText(position+1+"");

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                nhanvienDao.deleteSudent(nhanvien.ten);
                nhanvienList.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });


        return convertView;


    }
}
