package com.henreh.binus.photograpp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.henreh.binus.photograpp.R;
import com.henreh.binus.photograpp.controller.PhotographerHandler;
import com.henreh.binus.photograpp.model.Photographer;
import com.henreh.binus.photograpp.model.Request;

import java.util.Vector;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{
    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout photographerButton;
        ImageView profilePic, calenderIcon, gpsIcon;
        TextView userName, category, orderDate, location;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photographerButton = itemView.findViewById(R.id.photographerButton);
            profilePic = itemView.findViewById(R.id.profilePic);
            calenderIcon = itemView.findViewById(R.id.calenderIcon);
            gpsIcon = itemView.findViewById(R.id.gpsIcon);
            userName = itemView.findViewById(R.id.userName);
            category = itemView.findViewById(R.id.category);
            orderDate = itemView.findViewById(R.id.orderDate);
            location = itemView.findViewById(R.id.location);
        }
    }

    protected Context context;
    protected Vector<Request> PhotographerList;
    protected View v;
    public HistoryAdapter(Vector<Request> PhotographerList, Context context){
        this.PhotographerList=PhotographerList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(context).inflate(R.layout.history_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Request request = PhotographerList.get(position);
//
//        PhotographerHandler pH=new PhotographerHandler(context);
//
//        Photographer photographer= pH.getOnePhotographer(request.photographerID);

//        holder.profilePic.setBackground(Drawable.createFromPath(photographer.profilePicture));//pics
//        holder.calenderIcon.setBackground(Drawable.createFromPath("drawable/calendar_icon.png"));
//        holder.gpsIcon.setBackground(Drawable.createFromPath("drawable/gps_icon.png"));
//
//        holder.userName.setText(photographer.userName);
//        holder.category.setText(photographer.description);
//        holder.orderDate.setText(request.eventDate.toString());
//        holder.location.setText("Jakarta[temp]");

        holder.profilePic.setBackground(Drawable.createFromPath("profile_icon.png"));//pics
        holder.calenderIcon.setBackground(Drawable.createFromPath("calendar_icon.png"));
        holder.gpsIcon.setBackground(Drawable.createFromPath("gps_icon.png"));

        holder.userName.setText("[UserName]");
        holder.category.setText("[Desc]");
        holder.orderDate.setText("[dd-mm-yy OrderDate]");
        holder.location.setText("Jakarta[temp]");

        holder.photographerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(null)
                        .setMessage("NotImplemented").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return PhotographerList.size();
    }
}
