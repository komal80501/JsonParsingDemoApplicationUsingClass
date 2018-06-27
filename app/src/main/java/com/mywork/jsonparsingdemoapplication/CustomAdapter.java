package com.mywork.jsonparsingdemoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;

public class CustomAdapter extends BaseAdapter {
    /*********** Declare Variables *********/
    ArrayList<User> allusers;
    Context context;
//   ArrayList<String> Emails;
    private static LayoutInflater inflater=null;

    /*************  CustomAdapter Constructor *****************/
    public CustomAdapter(Context activity, ArrayList<User> users) {
        /********** Take passed values **********/
        context=activity;
        allusers=users;
        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /******** What is the size of Passed Arraylist Size ************/
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return allusers.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    /********* Create a holder Class to contain inflated xml file elements *********/
    public class Holder
    {
        TextView id;
        TextView name;
        TextView email;
        TextView address;
        TextView gender;
        TextView mobile;
        TextView homeno;
        TextView officeno;
    }
    /****** Depends upon data size called for each row , Create each ListView row *****/
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView;
        /****** Inflate list_item.xml file for each row ( Defined below ) *******/
        rowView = inflater.inflate(R.layout.list_item, null);
        /****** View Holder Object to contain tabitem.xml file elements ******/
        Holder holder=new Holder();
        holder.id=(TextView) rowView.findViewById(R.id.id);
        holder.name=(TextView) rowView.findViewById(R.id.name);
        holder.address=(TextView) rowView.findViewById(R.id.addr);
        holder.gender=(TextView) rowView.findViewById(R.id.gender);
        holder.homeno=(TextView) rowView.findViewById(R.id.homeno);
        holder.mobile=(TextView) rowView.findViewById(R.id.mobileno);
        holder.officeno=(TextView) rowView.findViewById(R.id.officeno);
        holder.email=( TextView) rowView.findViewById(R.id.email);


        holder.id.setText(allusers.get(position).id);
        holder.name.setText(allusers.get(position).name);
        holder.email.setText(allusers.get(position).email);
        holder.address.setText(allusers.get(position).address);
        holder.gender.setText(allusers.get(position).gender);
        holder.mobile.setText(allusers.get(position).mobile);
        holder.officeno.setText(allusers.get(position).officeno);
        holder.homeno.setText(allusers.get(position).homeno);


        /******** Set Item Click Listner for for each row *******/
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+allusers.get(position).name, Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

}