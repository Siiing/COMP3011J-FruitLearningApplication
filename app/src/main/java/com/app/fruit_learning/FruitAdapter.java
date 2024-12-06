package com.app.fruit_learning;

/**
 * @Author Siying.Li
 * @Date 2024/10/19 16:10
 * @Version 1.0
 */
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
    private List<Fruit> fruitList;

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        //get the image and name of fruits
        public FruitViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.text1);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        return new FruitViewHolder(view);
    }

    //get name and image, and set different colors for fruits
    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.textView.setText(fruit.getName());
        holder.imageView.setImageResource(fruit.getImageResId());
        holder.textView.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), fruit.getColor()));

        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), FruitDetailActivity.class);
            intent.putExtra("FRUIT_NAME", fruit.getName());
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
