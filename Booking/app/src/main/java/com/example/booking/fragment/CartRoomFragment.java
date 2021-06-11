package com.example.booking.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.booking.Adapter.CartAdapter;
import com.example.booking.Adapter.YourBookingRoomDetailAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.CartActivity;
import com.example.booking.Model.Booking_card;
import com.example.booking.Model.YBookingDetail;
import com.example.booking.R;
import com.example.booking.YourbookingdetailActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartRoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartRoomFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
   Button btCll;
    // TODO: Rename and change types of parameters
     String username="";
    int id=0;
    private CartActivity mainActivity;
    List<YBookingDetail> booking_details ;
    ListView lvRoom_detail ;
    CartAdapter adapter;
    Button btConfirm;
   private int bookingID;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public CartRoomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartRoomFragment newInstance(String param1, String param2) {
        CartRoomFragment fragment = new CartRoomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username= getArguments().getString("username");
            id = getArguments().getInt("id");


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_room, container, false);


        lvRoom_detail = view.findViewById(R.id.lvRoom_detail);
        mainActivity = (CartActivity) getActivity();
        username  = mainActivity.getUsername();
        btConfirm = (Button)view.findViewById(R.id.btConfirm);

        booking_details = new ArrayList<>();

        callApiListRoom();
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeStatus();
            }
        });
        return view;
    }
    public void setAdapter(List<YBookingDetail> hi){
        adapter = new CartAdapter(this,
                R.layout.custom_bookingcart, hi);
//        bookingID = hi.get(0).getBookingcart_id();
//        String i=  String.valueOf(bookingID);
//     Toast.makeText(getContext(), i, Toast.LENGTH_SHORT).show();
        lvRoom_detail.setAdapter(adapter);
    }
    private void callApiListRoom(){
        ApiService.API_SERVICE.GetBookingDetailCart(username).enqueue(new Callback<List<YBookingDetail>>() {
            @Override
            public void onResponse(Call<List<YBookingDetail>> call, Response<List<YBookingDetail>> response) {
                booking_details =response.body();
                if(booking_details!=null) {
                       setBookingID(response.body().get(0).getBookingcart_id());
                       setAdapter(booking_details);
                   }

            }

            @Override
            public void onFailure(Call<List<YBookingDetail>> call, Throwable t) {

            }
        });
    }
    private  void ChangeStatus(){
        ApiService.API_SERVICE.ChangeStatus(getBookingID(),false).enqueue(new Callback<Booking_card>() {
            @Override
            public void onResponse(Call<Booking_card> call, Response<Booking_card> response) {
                Toast.makeText(getContext(), "NO", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Booking_card> call, Throwable t) {
                     Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
            }
        });
}


}