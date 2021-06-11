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
