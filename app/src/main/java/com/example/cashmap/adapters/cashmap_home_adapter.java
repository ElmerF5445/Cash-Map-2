package com.example.cashmap.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;

import com.example.cashmap.data.*;
import com.example.cashmap.*;

import java.util.List;
import java.util.Objects;

public class cashmap_home_adapter extends BaseAdapter {
    private Context context;
    private List<cashmap_home_data> ATM_List;
    private View view;

    public cashmap_home_adapter(Context context, List<cashmap_home_data> ATM_List, View view){
        this.context = context;
        this.ATM_List = ATM_List;
        this.view = view;
    }

    @Override
    public int getCount() {
        return ATM_List.size();
    }

    @Override
    public Object getItem(int position) {
        return ATM_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        TextView ATM_Location;
        TextView ATM_Status;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder ATM;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.card_home_banklist, parent, false);
            ATM = new ViewHolder();
            ATM.ATM_Location = convertView.findViewById(R.id.Card_BankList_Item_Location);
            ATM.ATM_Status = convertView.findViewById(R.id.Card_BankList_Item_Status_Text);

            convertView.setTag(ATM);
        } else {
            ATM = (ViewHolder) convertView.getTag();
        }

        cashmap_home_data Info = ATM_List.get(position);
        ATM.ATM_Location.setText(Info.getATM_Location());
        ATM.ATM_Status.setText(Info.getATM_Status());
        if (Objects.equals(Info.getATM_Status(), "Active")){
            ATM.ATM_Status.setTextColor(Color.GREEN);
        } else {
            ATM.ATM_Status.setTextColor(Color.RED);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_home2_to_map);
            }
        });

        return convertView;
    }
}
