package vn.edu.poly.quanlynhanvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LopAdapter extends BaseAdapter {

    private Context context;
    private List<Lop> lopList;
    private LopDao lopDao;

    public LopAdapter(Context contex,List<Lop> lopList ){
        this.context=contex;
        this.lopList=lopList;
        this.lopDao=new LopDao(contex);
    }
    @Override
    public int getCount() {
        return lopList.size();
    }

    @Override
    public Object getItem(int position) {
        return lopList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.mer,parent,false);
        TextView tvMalop = convertView.findViewById(R.id.tvMalop);
        TextView tvTenlop = convertView.findViewById(R.id.tvTenlop);
        TextView tvStt = convertView.findViewById(R.id.tvStt);

        final Lop lop=(Lop) getItem(position);
            tvMalop.setText("Mã Lớp : " +lop.malop);
        tvTenlop.setText("Tên Lớp : "+lop.tenlop);
        tvStt.setText(position+1+"");

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                lopDao.deleteSudent(lop.malop);
                lopList.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });
        return convertView;
    }
}
