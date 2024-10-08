package com.example.oderfoodapp.recyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oderfoodapp.R;
import com.example.oderfoodapp.object.Food;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<Food> cartItemList;

    public CartAdapter(Context context, List<Food> cartItemList) {
        this.context = context;
        this.cartItemList = cartItemList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_order_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Food product = cartItemList.get(position);
        holder.txtFoodName.setText(product.getName());
        holder.txtPrice.setText(product.getPrice() + "$");
        holder.txtQuantity.setText(String.valueOf(product.getQuantity()));
        int imageResource = holder.itemView.getContext().getResources().getIdentifier(product.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imgFood.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    // Khai báo lớp ViewHolder bên trong Adapter
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView txtFoodName, txtQuantity, txtPrice;
        ImageView imgFood;
        ImageButton btnDecrease, btnIncrease;
        Button btnDelete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFoodName = itemView.findViewById(R.id.tvProductName);
            txtQuantity = itemView.findViewById(R.id.tvQuantity);
            txtPrice = itemView.findViewById(R.id.tvProductPrice);
            imgFood = itemView.findViewById(R.id.imgProduct);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

