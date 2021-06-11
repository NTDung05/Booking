package com.example.booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.Api.ApiService;
import com.example.booking.CartActivity;
import com.example.booking.MainActivity;
import com.example.booking.Model.Booking_Detail;
import com.example.booking.Model.Service;
import com.example.booking.R;
import com.example.booking.fragment.CartServiceFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceAdapter extends BaseAdapter {
    private CartServiceFragment context;
    private int layout;
    private List<Service> serviceDetail;
   private int bookingID;
   private int idService;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    private class ViewHolder {
        TextView tvServicesName, tvQuantity, tvPrice;
        ImageView btdelete;
    }

    public ServiceAdapter(CartServiceFragment context, int layout, List<Service> serviceDetail) {
        this.context = context;
        this.layout = layout;
        this.serviceDetail = serviceDetail;
    }

    @Override
    public int getCount() {
        return serviceDetail.size();
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
            LayoutInflater inflater = LayoutInflater.from(context.getContext());
            convertView = inflater.inflate(layout, null);
           holder.btdelete = (ImageView)convertView.findViewById(R.id.btdelete);
            holder.tvServicesName = (TextView) convertView.findViewById(R.id.servicesName);
            holder.tvQuantity = (TextView) convertView.findViewById(R.id.quantity);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.price);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //Service detail = serviceDetail.get(position);
            holder.btdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteService();


                }
            });
        Service detail = serviceDetail.get(position);
        setBookingID(detail.getBookingcart_id());
        setIdService(detail.getId());
        holder.tvServicesName.setText(detail.getService_name().toString());
        holder.tvPrice.setText(String.valueOf(detail.getPrice()));
        holder.tvQuantity.setText(String.valueOf(detail.getQuantity()));

        return convertView;
    }
    public void deleteService(){
        ApiService.API_SERVICE.DeleteService(getBookingID(), getIdService()).enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                Toast.makeText(context.getContext(),"hehe", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                Toast.makeText(context.getContext(),"OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
