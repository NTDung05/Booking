package com.example.booking.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.booking.Adapter.YourBookingRoomDetailAdapter;
import com.example.booking.Adapter.YourBookingServiceDetailAdapter;
import com.example.booking.Api.ApiService;
import com.example.booking.Model.Booking_Detail;
import com.example.booking.Model.Service;
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
 * Use the {@link ServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private YourbookingdetailActivity mainActivity;
    ListView lvService_detail;
    YourBookingServiceDetailAdapter adapter;
    // TODO: Rename and change types of parameters
     String username="";
    int id=0;
    List<Service> services ;
    public ServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
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
       //     username= getArguments().getString("username");
         //   id = getArguments().getInt("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);
         lvService_detail = view.findViewById(R.id.lvService_detail);

        mainActivity = (YourbookingdetailActivity) getActivity();
       username = mainActivity.getUsername();
       id=mainActivity.getId();
        services = new ArrayList<>();
        callApiListService();


        return view;
    }
    public void setAdapter(List<Service> hi){
        adapter = new YourBookingServiceDetailAdapter(this,
                R.layout.custom_listview_servicedetail, hi);

        lvService_detail.setAdapter(adapter);
    }
    private void callApiListService(){
        ApiService.API_SERVICE.GetServiceDetail(username,id).enqueue(new Callback<List<Service>>() {
            @Override
            public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
                services = response.body();
                setAdapter(services);
                Log.e("hi", "Thnh công12312 ");
            }

            @Override
            public void onFailure(Call<List<Service>> call, Throwable t) {

            }
        });
}
}