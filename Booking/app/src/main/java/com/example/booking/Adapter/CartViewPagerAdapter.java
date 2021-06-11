package com.example.booking.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.booking.fragment.CartRoomFragment;
import com.example.booking.fragment.CartServiceFragment;
import com.example.booking.fragment.RoomFragment;
import com.example.booking.fragment.ServiceFragment;

public class CartViewPagerAdapter extends FragmentStatePagerAdapter {
    public CartViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CartRoomFragment();
            case 1:
                return new CartServiceFragment();
            default:return  new CartRoomFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = " ";
        switch (position){
            case 0:
               title="Room";
               break;
            case 1:
                title="Service";
                break;
        }
        return title;
    }
}
