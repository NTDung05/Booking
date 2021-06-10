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
import com.example.booking.Model.YBookingDetail;
import com.example.booking.R;
import com.example.booking.YourBookingActivity;
import com.example.booking.fragment.RoomFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YourBookingRoomDetailAdapter extends BaseAdapter {
private List<YBookingDetail> detailBookings ;
private RoomFragment context;
private  int layout;



    public YourBookingRoomDetailAdapter(RoomFragment context, int layout, List<YBookingDetail> detailBookings) {
       this.context = context;
       this.layout = layout;
       this.detailBookings = detailBookings;

    }
    @Override
    public int getCount() {
        return detailBookings.size();
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
        YourBookingRoomDetailAdapter.ViewHolder holder;

        if (convertView == null) {
            holder = new YourBookingRoomDetailAdapter.ViewHolder();
            LayoutInflater inflater ;
            inflater  = LayoutInflater.from(context.getContext());
            convertView = inflater.inflate(layout, null);
            holder.tvCode = (TextView) convertView.findViewById(R.id.tvCode);
            holder.tvamount = (TextView) convertView.findViewById(R.id.tvamount);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.imgAvatar);

            convertView.setTag(holder);
        } else {
            holder = (YourBookingRoomDetailAdapter.ViewHolder) convertView.getTag();
        }
        YBookingDetail roomdetail = detailBookings.get(position);

        holder.tvCode.setText(roomdetail.getNameType());
        holder.tvamount.setText(String.valueOf(roomdetail.getAmount()));
        holder.tvPrice.setText(String.valueOf(roomdetail.getPrice()));
        holder.tvDate.setText(roomdetail.getRecieveAt()+" - "+roomdetail.getBackAt());
        if(roomdetail.getNameType().equals("Superior")){
            Picasso.with(context.getContext())
                    .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-02.jpg")
                    .into(holder.imgAvatar);}
        if(roomdetail.getNameType().equals("Standard")){
            Picasso.with(context.getContext())
                    .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-01.jpg")
                    .into(holder.imgAvatar);}
        if(roomdetail.getNameType().equals("Deluxe")){
            Picasso.with(context.getContext())
                    .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-03.jpg")
                    .into(holder.imgAvatar);}
        if(roomdetail.getNameType().equals("Suite")){
            Picasso.with(context.getContext())
                    .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-04.jpg")
                    .into(holder.imgAvatar);}
        if(roomdetail.getNameType().equals("Suite")){
            Picasso.with(context.getContext())
                    .load("https://www.hoteljob.vn/files/Anh-Hoteljob-Ni/Nam-2021/Thang-3/Cac-lo%E1%BA%A1i-phong-khach-san-05.jpg")
                    .into(holder.imgAvatar);}

        return convertView;
    }

    private class ViewHolder{
        TextView tvCode, tvamount, tvDate,tvPrice;
        ImageView imgAvatar;
    }
}
