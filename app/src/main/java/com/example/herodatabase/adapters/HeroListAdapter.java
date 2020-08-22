package com.example.herodatabase.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.herodatabase.HeroDetail;
import com.example.herodatabase.R;
import com.example.herodatabase.models.SuperHero;
import com.example.herodatabase.utils.ImageUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeroListAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Activity context;
    ArrayList<SuperHero> heroList;

    public HeroListAdapter(Activity context, ArrayList<SuperHero> heroList){
        this.context= context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent,false);
        return new HeroViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final SuperHero hero = heroList.get(position);
        final HeroViewHolder viewHolder = (HeroViewHolder) holder;
        viewHolder.heroName.setText(hero.getName());
        viewHolder.id = hero.getId();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), HeroDetail.class);
                intent.putExtra("HeroId", hero.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
        Picasso.get().load(hero.getImage().getUrl()).into(viewHolder.image, new Callback() {
            @Override
            public void onSuccess() {
                //TODO: Make a callback to normalize size and add circular feel
                //Rounding Image
                viewHolder.image.setImageDrawable(ImageUtils.RoundImage(viewHolder.image));
            }

            @Override
            public void onError(Exception e) {
                viewHolder.image.setImageResource(R.drawable.ic_launcher_background);
            }
        });
    }

    public String getHeroId(int position){
        return heroList.get(position).getId();
    }

    public void clear() {
        heroList.clear();
        notifyDataSetChanged();

    }

    public void addAll(ArrayList<SuperHero> list) {
        heroList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView heroName;
        String id;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.list_hero_image);
            heroName = itemView.findViewById(R.id.list_hero_name);
        }
    }
}
