package com.example.oderfoodapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oderfoodapp.R;
import com.example.oderfoodapp.object.Food;
import com.example.oderfoodapp.recyclerViewAdapter.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewCart;
    private CartAdapter cartAdapter;
    private List<Food> cartItemList;

    public CartFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CartFrag newInstance(String param1, String param2) {
        CartFrag fragment = new CartFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_frag, container, false);

        // Khởi tạo RecyclerView và Adapter
        recyclerViewCart = view.findViewById(R.id.listFoodOrder);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(getContext()));

        // Dữ liệu mẫu cho các item trong giỏ hàng
        cartItemList = new ArrayList<>();
        cartItemList.add(new Food("Gà rán Texas Original", 2, 400, "garena"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));
        cartItemList.add(new Food("Gà rán Texas", 3, 200, "garena1"));

        // Cài đặt Adapter cho RecyclerView
        cartAdapter = new CartAdapter(getContext() ,cartItemList);
        recyclerViewCart.setAdapter(cartAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewCart.getContext(), LinearLayoutManager.VERTICAL);
        recyclerViewCart.addItemDecoration(dividerItemDecoration);

        return view;
    }
}