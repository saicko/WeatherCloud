package com.saickodevelopment.weathercloud.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.saickodevelopment.weathercloud.R;
import com.saickodevelopment.weathercloud.weather.Hour;

/**
 * Created by Gary on 7/5/2015.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    public Hour[] mHours;
    private Context mContext;


    public HourAdapter(Context context, Hour[] hours){
        mContext = context;
        mHours = hours;

    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)  {  //ovdje mozda bude greska(viewGroup/parent)

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourly_list_item, viewGroup, false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder hourViewHolder, int i) { //!!!(i/position)
        hourViewHolder.bindHour(mHours[i]);

    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTimelabel;
        public TextView mSummaryLabel;
        public TextView mTemperatureLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            mTimelabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            mTimelabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(hour.getTemperature() + "°");
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View v) {
            String time = mTimelabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temperature, summary);

            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }

}//!!!