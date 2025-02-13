package com.example.cashmap.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;

import com.example.cashmap.data.cashmap_onboarding_data;
import com.example.cashmap.*;

import java.util.List;

public class cashmap_onboarding_adapter extends BaseAdapter {
    private Context context;
    private List<cashmap_onboarding_data> Bank_List;
    private View view;

    public cashmap_onboarding_adapter(Context context, List<cashmap_onboarding_data> Bank_List, View view){
        this.context = context;
        this.Bank_List = Bank_List;
        this.view = view;
    }

    @Override
    public int getCount() {
        return Bank_List.size();
    }

    @Override
    public Object getItem(int position) {
        return Bank_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        TextView Bank_Name;
        ImageView Bank_Background;
        ImageView Bank_Logo;
        TextView Bank_Decoration;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder Card;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.card_onboarding_bank, parent, false);
            Card = new ViewHolder();
            Card.Bank_Name = convertView.findViewById(R.id.Bank_Name);
            Card.Bank_Background = convertView.findViewById(R.id.Bank_Background);
            Card.Bank_Logo = convertView.findViewById(R.id.Bank_Logo);
            Card.Bank_Decoration = convertView.findViewById(R.id.Bank_Decoration);
            convertView.setTag(Card);
        } else {
            Card = (ViewHolder) convertView.getTag();
        }

        cashmap_onboarding_data Info = Bank_List.get(position);
        Card.Bank_Name.setText(Info.getBank_Name());
        Card.Bank_Background.setImageResource(Info.getBank_Background());
        Card.Bank_Logo.setImageResource(Info.getBank_Logo());
        Card.Bank_Decoration.setText(Info.getBank_Decoration());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_onboarding_to_home2);
            }
        });
        return convertView;
    }
}
