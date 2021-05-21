package com.example.booking.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.booking.BookingActivity;
import com.example.booking.Model.Booking;
import com.example.booking.Model.Room;
import com.example.booking.R;
import com.example.booking.YourBookingActivity;
import com.squareup.picasso.Picasso;


import java.util.List;

public class YourBookingAdapter extends BaseAdapter {

    private YourBookingActivity context;
    private int layout;
    private List<Booking> listYourBooking;

    public YourBookingAdapter(YourBookingActivity context, int layout, List<Booking> listYourBooking) {
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
        TextView tvNgayDat,tvNgayTra,tvLoaiPhong,tvGia;
        ImageView imgRoom;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.tvNgayDat = (TextView) convertView.findViewById(R.id.tvNgayDat);
            holder.tvNgayTra = (TextView) convertView.findViewById(R.id.tvNgayTra);
            holder.tvLoaiPhong= (TextView) convertView.findViewById(R.id.tvLoaiPhong);
            holder.tvGia= (TextView) convertView.findViewById(R.id.tvGia);
            holder.imgRoom = (ImageView) convertView.findViewById(R.id.imgRoom);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

             Booking booking = listYourBooking.get(position);
          //   holder.tvNgayDat.setText();
         //    holder.tvNgayTra.setText();
           //  holder.tvLoaiPhong.setText();
            // holder.tvGia.setText();
        Picasso.with(context)
                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                .into(holder.imgRoom);
        //bắt sự kiện xóa & sửa


        return convertView;
    }
}