package com.zybooks.thebanddatabase.Controller;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zybooks.thebanddatabase.Model.Band;
import com.zybooks.thebanddatabase.Model.BandRepository;
import com.zybooks.thebanddatabase.R;

import org.w3c.dom.Text;

public class DetailFragment extends Fragment {

    private Band mBand;
    public static final String ARG_BAND_ID = "band_id";

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int bandId = 1;

        // Get the band ID from the fragment arguments
        Bundle args = getArguments();
        if (args != null) {
            bandId = args.getInt(ARG_BAND_ID);
        }


        // Get the selected band
        mBand = BandRepository.getInstance(requireContext()).getBand(bandId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if (mBand != null) {
            //Name Set
            TextView nameTextView = rootView.findViewById(R.id.band_name);
            nameTextView.setText(mBand.getName());

            //Description Set
            TextView descriptionTextView = rootView.findViewById(R.id.band_description);
            descriptionTextView.setText(mBand.getDescription());

            //ImageSet
            ImageView bandImageView = rootView.findViewById(R.id.band_img);
            int resId = getResources().getIdentifier(mBand.getImg(), "drawable", "com.zybooks.thebanddatabase");
            bandImageView.setImageResource(resId);

            //LinkSet
            TextView linkTextView = rootView.findViewById(R.id.band_link);
            linkTextView.setOnClickListener(v -> {
                //intent
                String url = mBand.getLink();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            });
        }

        return rootView;
    }

}