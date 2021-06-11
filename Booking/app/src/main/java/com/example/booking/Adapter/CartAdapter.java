package com.example.booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.example.booking.Api.ApiService;
import com.example.booking.CartActivity;
import com.example.booking.Model.YBookingDetail;
import com.example.booking.R;
import com.example.booking.fragment.CartRoomFragment;
import com.example.booking.fragment.CartServiceFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartAdapter extends BaseAdapter {
    private CartRoomFragment context;
    private int layout;
    private List<YBookingDetail> bookingRooms;
    private int bookingID;
    private int idRoom;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public CartAdapter(CartRoomFragment context, int layout, List<YBookingDetail> bookingRooms) {
        this.context = context;
        this.layout = layout;
        this.bookingRooms = bookingRooms;
    }


    @Override
    public int getCount() {
        return bookingRooms.size() ;
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

        TextView tvname, tvamount, price;
        ImageView  imageV;
        ImageView btdelete;
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(context.getContext());
        convertView = inflater.inflate(layout, null);
            holder.btdelete = (ImageView)convertView.findViewById(R.id.btdelete);
            holder.tvname = (TextView) convertView.findViewById(R.id.name);
        holder.tvamount = (TextView) convertView.findViewById(R.id.amount);
        holder.imageV = (ImageView) convertView.findViewById(R.id.imageHinh);
          holder.price = (TextView)convertView.findViewById(R.id.price);

        convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        YBookingDetail booking = bookingRooms.get(position);

        holder.btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRoom();
            }
        });
        setBookingID(booking.getBookingcart_id());
        setIdRoom(booking.getIdType());
       holder.tvname.setText(booking.getNameType());
       holder.tvamount.setText("Số lượng: " + String.valueOf(booking.getAmount()));
       holder.price.setText("Giá: "+ String.valueOf(booking.getPrice()));
        return convertView;
    }
private void deleteRoom(){
    ApiService.API_SERVICE.DeleteRoom(getBookingID(),getIdRoom()).enqueue(new Callback<YBookingDetail>() {
        @Override
        public void onResponse(Call<YBookingDetail> call, Response<YBookingDetail> response) {
            Toast.makeText(context.getContext(),"Xoá thành công", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<YBookingDetail> call, Throwable t) {
            Toast.makeText(context.getContext(),"Thử L", Toast.LENGTH_SHORT).show();
        }
    });
}


    }

