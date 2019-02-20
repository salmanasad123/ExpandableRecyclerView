package com.example.teamas.expandablerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private Context context;
    private List<Model> modelList;


    public ModelAdapter(MainActivity mainActivity, List<Model> modelList) {
        context = mainActivity;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_single_row, viewGroup, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ModelViewHolder modelViewHolder, final int i) {
        final Model model = modelList.get(i);

        modelViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.isCollapsed()) {
                    model.setExpanded(false);
                } else {
                    model.setExpanded(true);
                }
                notifyItemChanged(i);
            }
        });


        if (model.isExpanded()) {
            modelViewHolder.subItem.setVisibility(View.VISIBLE);
            modelViewHolder.title.setText(model.getTitle());
            modelViewHolder.genre.setText("Genre: " + model.getGenre());
            modelViewHolder.year.setText("Year: " + model.getYear());
            model.setCollapsed(true);
        } else {
            modelViewHolder.subItem.setVisibility(View.GONE);
            modelViewHolder.title.setText(model.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView genre;
        private TextView year;
        private LinearLayout subItem;


        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            genre = itemView.findViewById(R.id.sub_item_genre);
            year = itemView.findViewById(R.id.sub_item_year);
            subItem = itemView.findViewById(R.id.sub_item);
        }
    }
}
