package com.example.booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booking.BookingActivity;
import com.example.booking.Model.Room;
import com.example.booking.R;
import com.example.booking.YourBookingActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RoomAdapter extends BaseAdapter {
    private BookingActivity context;
    private int layout;
    private List<Room> listRoom;

    public RoomAdapter(BookingActivity context, int layout, List<Room> listRoom) {
        this.context = context;
        this.layout = layout;
        this.listRoom = listRoom;
    }

    @Override
    public int getCount() {
        return listRoom.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    private class ViewHolder {

        TextView tvCode, tvType, tvDescription;
        ImageView imgAvatar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.tvCode = (TextView) convertView.findViewById(R.id.tvCode);
            holder.tvType = (TextView) convertView.findViewById(R.id.tvType);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.imgAvatar);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        Room room = listRoom.get(position);

        holder.tvCode.setText(String.valueOf(room.getCode()));
        holder.tvType.setText(room.getType().toString());
        holder.tvDescription.setText(room.getDescription().toString());
        Picasso.with(context)
                .load(room.getAvatar())
                .into(holder.imgAvatar);

        return convertView;
    }
}
