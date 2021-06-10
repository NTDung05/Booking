package com.example.booking.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.booking.Adapter.YourBookingRoomDetailAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.MainActivity;
import com.example.booking.Model.Booking_Detail;
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
 * Use the {@link RoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoomFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
   Button btCll;
    // TODO: Rename and change types of parameters
     String username="";
    int id=0;
    private YourbookingdetailActivity mainActivity;
    List<YBookingDetail> booking_details ;
    ListView lvRoom_detail ;
    YourBookingRoomDetailAdapter adapter;
    public RoomFragment() {
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
    public static RoomFragment newInstance(String param1, String param2) {
        RoomFragment fragment = new RoomFragment();
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

        //   Toast.makeText(getContext(),username,Toast.LENGTH_LONG).show();
      //  btCll= view.findViewById(R.id.btCll);
        lvRoom_detail = view.findViewById(R.id.lvRoom_detail);
        mainActivity = (YourbookingdetailActivity) getActivity();
        username  = mainActivity.getUsername();
        id = mainActivity.getId();
        booking_details = new ArrayList<>();
     //   booking_details= (List<YBookingDetail>) getArguments().getSerializable("room");
     //  booking_details = mainActivity.sendData();
        callApiListRoom();

        return view;
    }
    public void setAdapter(List<YBookingDetail> hi){
        adapter = new YourBookingRoomDetailAdapter(this,
                R.layout.custom_listview_roomdetail, hi);

        lvRoom_detail.setAdapter(adapter);
    }
    private void callApiListRoom(){
        ApiService.API_SERVICE.GetBookingDetail(username,id).enqueue(new Callback<List<YBookingDetail>>() {
            @Override
            public void onResponse(Call<List<YBookingDetail>> call, Response<List<YBookingDetail>> response) {
                booking_details =response.body();
                setAdapter(booking_details);
              String i=  String.valueOf(booking_details.size());
                Log.e("hi", i);

            }

            @Override
            public void onFailure(Call<List<YBookingDetail>> call, Throwable t) {

            }
        });
    }

}