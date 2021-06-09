package com.example.booking.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import com.example.booking.BookingActivity;
import com.example.booking.Model.Booking;
import com.example.booking.Model.Booking_card;
import com.example.booking.Model.Room;
import com.example.booking.R;
import com.example.booking.YourBookingActivity;
import com.squareup.picasso.Picasso;


import java.util.List;

public class YourBookingAdapter extends BaseAdapter {

    private YourBookingActivity context;
    private int layout;
    private List<Booking_card> listYourBooking;

    public YourBookingAdapter(YourBookingActivity context, int layout, List<Booking_card> listYourBooking) {
        this.context = context;
        this.layout = layout;
        this.listYourBooking = listYourBooking;
    }

    @Override
    public int getCount() {
        return listYourBooking.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView tvID,tvNgayDat,tvNgayTra,tvLoaiPhong,tvGia;
        ImageView imgRoom;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
     //       holder.tvNgayDat = (TextView) convertView.findViewById(R.id.tvNgayDat);
     //       holder.tvNgayTra = (TextView) convertView.findViewById(R.id.tvNgayTra);
            holder.tvID = (TextView) convertView.findViewById(R.id.tvID);
            holder.tvLoaiPhong= (TextView) convertView.findViewById(R.id.tvLoaiPhong);
            holder.tvGia= (TextView) convertView.findViewById(R.id.tvGia);
            holder.imgRoom = (ImageView) convertView.findViewById(R.id.imgRoom);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

             Booking_card booking = listYourBooking.get(position);
                    holder.tvID.setText("Mã HĐ: "+String.valueOf(booking.getId()));
                    holder.tvGia.setText("Tổng Tiền:"+String.valueOf(booking.getPrice())+" VNĐ");
                    holder.tvLoaiPhong.setText(booking.getStatus());



          if(booking.getStatus().equals("Reservated")){

                 holder.imgRoom.setImageResource(R.drawable.baseline_event_available_white_24dp);
              holder.imgRoom.setColorFilter(ContextCompat.getColor(context,
                      R.color.gradEnd),android.graphics.PorterDuff.Mode.MULTIPLY);
                }
       else if(booking.getStatus().equals("Done")){
      holder.imgRoom.setImageResource(R.drawable.baseline_done_all_white_24dp);
              holder.imgRoom.setColorFilter(ContextCompat.getColor(context,
                      R.color.gradEnd),android.graphics.PorterDuff.Mode.MULTIPLY);}
          else if(booking.getStatus().equals("Cancel")) {


              holder.imgRoom.setImageResource(R.drawable.baseline_do_disturb_alt_white_24dp);

              //bắt sự kiện xóa & sửa
              holder.imgRoom.setColorFilter(ContextCompat.getColor(context,
                      R.color.red),android.graphics.PorterDuff.Mode.MULTIPLY);

          }
        return convertView;
    }
}