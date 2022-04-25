package com.example.dadmballdontlie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadmballdontlie.R;
import com.example.dadmballdontlie.data.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFavsAdapter extends RecyclerView.Adapter<PlayerFavsAdapter.ViewHolder> {

    private List<Player> listPlayers;
    private OnItemLongClickListener longClickListener;
    private OnItemClickListener onItemClickListener;
    private OnRemoveFavClickListener onRemoveFavClickListener;

    public PlayerFavsAdapter(OnItemLongClickListener listener, OnItemClickListener onItemClickListener,
                             OnRemoveFavClickListener onRemoveFavClickListener){
        listPlayers = new ArrayList<>();
        this.longClickListener = listener;
        this.onItemClickListener = onItemClickListener;
        this.onRemoveFavClickListener = onRemoveFavClickListener;
    }

    @NonNull
    @Override
    public PlayerFavsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item,parent,false);
        PlayerFavsAdapter.ViewHolder holder = new PlayerFavsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerFavsAdapter.ViewHolder holder, int position) {
        holder.name.setText(listPlayers.get(position).getFirst_name() + " " + listPlayers.get(position).getLast_name());
        holder.team.setText(listPlayers.get(position).getTeam().getFull_name());
    }

    @Override
    public int getItemCount() {
        return listPlayers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView team;
        public ImageButton imageButton;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.textViewPlayer);
            team = itemView.findViewById(R.id.textViewPlayerTeam);
            imageButton = itemView.findViewById(R.id.imageButtonRemovePlayers);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    longClickListener.onItemLongClick(getPlayer(getAdapterPosition()));
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getPlayer(getAdapterPosition()));
                }
            });

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onRemoveFavClickListener.onRemoveClick(getPlayer(getAdapterPosition()));
                }
            });
        }

    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Player player);
    }

    public interface OnItemClickListener {
        void onItemClick(Player player);
    }

    public interface OnRemoveFavClickListener {
        void onRemoveClick(Player player);
    }

    public void updateList(List<Player> players) {
        listPlayers.clear();
        listPlayers.addAll(players);
        notifyDataSetChanged();
    }

    public Player getPlayer(int position) {
        return listPlayers.get(position);
    }

    public boolean isOnFavourites(Player player) {
        return listPlayers.contains(player);
    }

}