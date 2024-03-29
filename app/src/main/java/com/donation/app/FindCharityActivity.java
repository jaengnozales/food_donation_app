package com.donation.app;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FindCharityActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private Marker redCross;
    private Marker riseAgainstHunger;
    private Marker phFoodBankFoundation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_charity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng restaurant = new LatLng(14.539068, 120.981429);
        LatLng charity1 = new LatLng(14.541267, 120.985460);
        LatLng charity2 = new LatLng(14.538110, 120.980311);
        LatLng charity3 = new LatLng(14.536717, 120.984964);

//        LatLngBounds bounds = new LatLngBounds.Builder()
//                .include(restaurant)
//                .include(charity1)
//                .include(charity2)
//                .include(charity3)
//                .build();

        mMap.addCircle(new CircleOptions()
                .center(restaurant)
                .fillColor(0x220000FF)
                .strokeColor(Color.BLUE)
                .radius(1000)
                .strokeWidth(1));

        mMap.addCircle(new CircleOptions()
                .center(restaurant)
                .fillColor(Color.BLUE)
                .strokeColor(Color.WHITE)
                .radius(50)
                .strokeWidth(1));

//        mMap.addMarker(new MarkerOptions().position(restaurant).title("Restaurant"));
        redCross = mMap.addMarker(new MarkerOptions().position(charity1)
                .title("Red Cross Philippines")
                .snippet("Click here to donate."));
        riseAgainstHunger = mMap.addMarker(new MarkerOptions().position(charity2)
                .title("Rise Against Hunger Philippines")
                .snippet("Click here to donate."));
        phFoodBankFoundation = mMap.addMarker(new MarkerOptions().position(charity3)
                .title("Philippine FoodBank Foundation")
                .snippet("Click here to donate."));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant, 14));

        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());

        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
//        if (marker.equals(mPerth)) {
//            // This causes the marker at Perth to bounce into position when it is clicked.
//            final Handler handler = new Handler();
//            final long start = SystemClock.uptimeMillis();
//            final long duration = 1500;
//
//            final Interpolator interpolator = new BounceInterpolator();
//
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    long elapsed = SystemClock.uptimeMillis() - start;
//                    float t = Math.max(
//                            1 - interpolator.getInterpolation((float) elapsed / duration), 0);
//                    marker.setAnchor(0.5f, 1.0f + 2 * t);
//
//                    if (t > 0.0) {
//                        // Post again 16ms later.
//                        handler.postDelayed(this, 16);
//                    }
//                }
//            });
//        } else if (marker.equals(mAdelaide)) {
//            // This causes the marker at Adelaide to change color and alpha.
//            marker.setIcon(BitmapDescriptorFactory.defaultMarker(mRandom.nextFloat() * 360));
//            marker.setAlpha(mRandom.nextFloat());
//        }

        // Markers have a z-index that is settable and gettable.
        float zIndex = marker.getZIndex() + 1.0f;
        marker.setZIndex(zIndex);
        final Toast mToast = Toast.makeText(this, marker.getTitle(),
                Toast.LENGTH_LONG);
//

        mToast.show();
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(FindCharityActivity.this, ShowCharityInfoActivity.class);
        intent.putExtra(Constants.SELECTED_CHARITY, marker.getTitle());
        startActivity(intent);
    }

    /** Demonstrates customizing the info window and/or its contents. */
    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        // These are both viewgroups containing an ImageView with id "badge" and two TextViews with id
        // "title" and "snippet".
        private final View mContents;

        CustomInfoWindowAdapter() {
            mContents = getLayoutInflater().inflate(R.layout.custom_info_contents, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker, mContents);
            return mContents;
        }

        private void render(Marker marker, View view) {
//            int badge;
//            // Use the equals() method on a Marker to check for equals.  Do not use ==.
//            if (marker.equals(mBrisbane)) {
//                badge = R.drawable.badge_qld;
//            } else if (marker.equals(mAdelaide)) {
//                badge = R.drawable.badge_sa;
//            } else if (marker.equals(mSydney)) {
//                badge = R.drawable.badge_nsw;
//            } else if (marker.equals(mMelbourne)) {
//                badge = R.drawable.badge_victoria;
//            } else if (marker.equals(mPerth)) {
//                badge = R.drawable.badge_wa;
//            } else if (marker.equals(mDarwin1)) {
//                badge = R.drawable.badge_nt;
//            } else if (marker.equals(mDarwin2)) {
//                badge = R.drawable.badge_nt;
//            } else if (marker.equals(mDarwin3)) {
//                badge = R.drawable.badge_nt;
//            } else if (marker.equals(mDarwin4)) {
//                badge = R.drawable.badge_nt;
//            } else {
//                // Passing 0 to setImageResource will clear the image view.
//                badge = 0;
//            }
//            ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.title));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the text.
                SpannableString titleText = new SpannableString(title);
                titleText.setSpan(new ForegroundColorSpan(Color.RED), 0, titleText.length(), 0);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }

            String snippet = marker.getSnippet();
            TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
            if (snippet != null && snippet.length() > 12) {
                SpannableString snippetText = new SpannableString(snippet);
                snippetText.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, 10, 0);
                snippetText.setSpan(new ForegroundColorSpan(Color.BLUE), 12, snippet.length(), 0);
                snippetUi.setText(snippetText);
            } else {
                snippetUi.setText("");
            }
        }
    }


}
