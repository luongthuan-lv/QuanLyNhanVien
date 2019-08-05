package vn.edu.poly.quanlynhanvien;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class MySpinerAdapter implements SpinnerAdapter {

    private List<Lop> lopList;
    private Context context;

    public MySpinerAdapter(Context context,List<Lop> lopList) {
        this.context=context;
        this.lopList = lopList;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.drop,parent,false);

        TextView tvMasp=convertView.findViewById(R.id.tvMasp);
        tvMasp.setText(lopList.get(position).malop);
        TextView tvNamesp=convertView.findViewById(R.id.tvNamesp);
        tvNamesp.setText(lopList.get(position).tenlop);
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.selected,parent,false);
        TextView tvMasp=convertView.findViewById(R.id.tvMasp);
        tvMasp.setText(lopList.get(position).malop);
        TextView tvNamesp=convertView.findViewById(R.id.tvNamesp);
        tvNamesp.setText(lopList.get(position).tenlop);
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
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
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public int getItemViewType(int position) {
        return 0;
    }



    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
}
