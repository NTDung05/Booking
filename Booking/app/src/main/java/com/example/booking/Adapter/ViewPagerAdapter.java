package com.example.booking.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.booking.fragment.RoomFragment;
import com.example.booking.fragment.ServiceFragment;

public class ViewPagerAdapter  extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RoomFragment();
            case 1:
                return new ServiceFragment();
            default:return  new RoomFragment();
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
