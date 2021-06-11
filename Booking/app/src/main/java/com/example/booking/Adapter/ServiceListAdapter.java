package com.example.booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.BookingActivity;
import com.example.booking.Model.Room_type;
import com.example.booking.Model.Service;
import com.example.booking.R;
import com.example.booking.ServiceActivivty;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ServiceListAdapter extends BaseAdapter {

    private ServiceActivivty context;
    private int layout;
    private List<Service> listService;

    public ServiceListAdapter(ServiceActivivty context, int layout, List<Service> listService) {
        this.context = context;
        this.layout = layout;
        this.listService = listService;
    }

    private class ViewHolder {

        TextView tvNameService, tvPrice;
        ImageView imgAdd,imgIcon;
    }

    @Override
    public int getCount() {
        return listService.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.tvNameService = (TextView) convertView.findViewById(R.id.tvNameService);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.imgAdd = (ImageView) convertView.findViewById(R.id.imgPlus);
            holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Service service = listService.get(position);

        holder.tvNameService.setText(service.getService_name().toString());

        holder.tvPrice.setText(String.valueOf(service.getPrice()));
        if(service.getService_name().equals("Ăn sáng")){
            Picasso.with(context)
                    .load("https://photo-cms-sggp.zadn.vn/w840/Uploaded/2021/evofjasfzyr/2020_05_12/banh-da-cua-kieu-rex-7_cklv.jpg")
                    .into(holder.imgIcon);}
        if(service.getService_name().equals("Giặt ủi")){
            Picasso.with(context)
                    .load("https://khachsansky.net/wp-content/uploads/2021/04/giatui3-min.jpg")
                    .into(holder.imgIcon);}
        if(service.getService_name().equals("Nước uống")){
            Picasso.with(context)
                    .load("https://doanhnhanplus.vn/wp-content/uploads/2019/03/dnp-5-loai-nuoc-uong-giai-nhiet-mua-he-link-280319-ok-750x456.jpg")
                    .into(holder.imgIcon);}
        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Thành công", Toast.LENGTH_LONG).show();
                context.diaLogOrder(service.getService_name(), service.getPrice());

            }
        });

        return convertView;
    }
}
