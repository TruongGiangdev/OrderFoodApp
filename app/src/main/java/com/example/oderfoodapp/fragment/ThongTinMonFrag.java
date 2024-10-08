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
import com.example.oderfoodapp.object.FoodDetails;
import com.example.oderfoodapp.recyclerViewAdapter.CartAdapter;
import com.example.oderfoodapp.recyclerViewAdapter.FoodDetailsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThongTinMonFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView listRating;
    private FoodDetailsAdapter foodDetailsAdapter;
    private List<FoodDetails> foodDetailsList;

    public ThongTinMonFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ThongTinMonFrag newInstance(String param1, String param2) {
        ThongTinMonFrag fragment = new ThongTinMonFrag();
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
        // Inflate layout của Fragment
        View view = inflater.inflate(R.layout.thong_tin_mon_frag, container, false);

        // Khởi tạo RecyclerView
        listRating = view.findViewById(R.id.listRating);
        listRating.setHasFixedSize(true);
        listRating.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo danh sách dữ liệu mẫu
        foodDetailsList = new ArrayList<>();
        foodDetailsList.add(new FoodDetails("anh_dai_dien", "Malenia", 4, "Đồ ăn rất ngon."));
        foodDetailsList.add(new FoodDetails("my_avatar", "Elysia", 5, "Gà rán gọi ra vẫn còn nóng, mềm mọng nước, bột gà giòn tan. Khoai tây chiên giòn ăn đã cái miệng."));
        foodDetailsList.add(new FoodDetails("anh_dai_dien", "Fire Keeper", 3, "Khoai tây hơi mềm."));

        // Tạo Adapter và liên kết với RecyclerView
        foodDetailsAdapter = new FoodDetailsAdapter(getContext(), foodDetailsList);
        listRating.setAdapter(foodDetailsAdapter);
        return view;
    }
}