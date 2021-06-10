package com.example.booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booking.Model.Booking_Detail;
import com.example.booking.Model.Booking_card;
import com.example.booking.Model.Service;
import com.example.booking.R;
import com.example.booking.YourBookingActivity;
import com.example.booking.fragment.RoomFragment;
import com.example.booking.fragment.ServiceFragment;

import java.util.List;

public class YourBookingServiceDetailAdapter extends BaseAdapter {
    private List<Service> details ;
    private ServiceFragment context;
    private  int layout;



    public YourBookingServiceDetailAdapter(ServiceFragment context, int layout, List<Service> details) {
        this.context = context;
        this.layout = layout;
        this.details = details;

    }
    @Override
    public int getCount() {
        return details.size();
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
        YourBookingServiceDetailAdapter.ViewHolder holder;

        if (convertView == null) {
            holder = new YourBookingServiceDetailAdapter.ViewHolder();
            LayoutInflater inflater ;
            inflater  = LayoutInflater.from(context.getContext());
            convertView = inflater.inflate(layout, null);
            holder.tvService = (TextView) convertView.findViewById(R.id.tvService);
            holder.tvAmount_service = (TextView) convertView.findViewById(R.id.tvAmount_service);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);


            convertView.setTag(holder);
        } else {
            holder = (YourBookingServiceDetailAdapter.ViewHolder) convertView.getTag();
        }
        Service service = details.get(position);

        holder.tvService.setText(service.getService_name());
       holder.tvPrice.setText(String.valueOf(service.getPrice()));
       holder.tvAmount_service.setText(String.valueOf(service.getQuantity()));

        return convertView;
    }

    private class ViewHolder{
        TextView tvService, tvAmount_service, tvPrice;

    }
}

