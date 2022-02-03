package com.zybooks.thebanddatabase.Model;
import android.content.Context;
import android.content.res.Resources;

import com.zybooks.thebanddatabase.R;

import java.util.ArrayList;
import java.util.List;

public class BandRepository {

    private static BandRepository instance;
    private List<Band> mBands;

    public static BandRepository getInstance(Context context) {
        if (instance == null) {
            instance = new BandRepository(context);
        }
        return instance;
    }

    private BandRepository(Context context) {
        mBands = new ArrayList<>();
        Resources res = context.getResources();
        String[] bands = res.getStringArray(R.array.bands);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        String[] imgs = res.getStringArray(R.array.imgs);
        String[] links = res.getStringArray(R.array.links);
        for (int i = 0; i < bands.length; i++) {
            mBands.add(new Band(i + 1, bands[i], descriptions[i], imgs[i], links[i]));
        }
    }

    public List<Band> getBands() {
        return mBands;
    }

    public Band getBand(int bandId) {
        for (Band band : mBands) {
            if (band.getId() == bandId) {
                return band;
            }
        }
        return null;
    }
}