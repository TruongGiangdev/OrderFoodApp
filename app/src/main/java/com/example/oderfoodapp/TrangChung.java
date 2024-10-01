package com.example.oderfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.oderfoodapp.fragment.CartFrag;
import com.example.oderfoodapp.fragment.ChangePWFrag;
import com.example.oderfoodapp.fragment.FavoriteFrag;
import com.example.oderfoodapp.fragment.HistoryFrag;
import com.example.oderfoodapp.fragment.ManageAccFrag;
import com.example.oderfoodapp.fragment.TrangChu;
import com.google.android.material.navigation.NavigationView;

public class TrangChung extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerTrangChung;

    //khai báo những const để ử lý hàm if else phía dưới
    private final int FRAG_TRANG_CHU = 0;
    private final int FRAG_MANAGE_ACC = 1;
    private final int FRAG_CHANGE_PW = 2;
    private final int FRAG_HISTORY = 3;
    private final int FRAG_CART = 4;
    private final int FRAG_FAVORITE = 5;

    private int currentFrag = FRAG_TRANG_CHU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.trang_chung);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerTrangChung = findViewById(R.id.drawer_TrangChu);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerTrangChung, toolbar, R.string.nav_open, R.string.nav_close);
        drawerTrangChung.addDrawerListener(toggle);
        toggle.syncState();

        // Kích hoạt nút "mũi tên" trong toolbar
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);

        // Sử dụng OnBackPressedDispatcher để xử lý nút Back
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Kiểm tra DrawerLayout có mở không
                if (drawerTrangChung.isDrawerOpen(GravityCompat.START)) {
                    drawerTrangChung.closeDrawer(GravityCompat.START);  // Đóng ngăn kéo nếu nó đang mở
                } else {
                    // Nếu không, thực hiện hành động mặc định
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        };
        // Đăng ký callback với dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);


        //trang chủ sẽ chạy đầu tiên khi đăng nhập thành công
        replaceFrag(new TrangChu());
        nav_view.getMenu().findItem(R.id.item_trang_chu).setChecked(true);

        //chỉnh lại kích thước để không trùng thanh trạng thái
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Sử dụng WindowInsets để điều chỉnh padding cho NavigationView
        ViewCompat.setOnApplyWindowInsetsListener(nav_view, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Cài đặt padding để NavigationView không đè lên thanh trạng thái
            v.setPadding(0, systemBars.top, 0, 0); // Chỉ đặt padding trên cho thanh trạng thái
            return insets;
        });
    }

    //xửa lý logic các item trong menu toolbar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item_trang_chu){
            if(currentFrag != FRAG_TRANG_CHU){
                replaceFrag(new TrangChu());
                currentFrag = FRAG_TRANG_CHU;
            }
        }
        else if(id == R.id.item_manage_acc){
            if(currentFrag != FRAG_MANAGE_ACC){
                replaceFrag(new ManageAccFrag());
                currentFrag = FRAG_MANAGE_ACC;
            }
        } else if (id == R.id.item_change_pw) {
            if(currentFrag != FRAG_CHANGE_PW){
                replaceFrag(new ChangePWFrag());
                currentFrag = FRAG_CHANGE_PW;
            }
        } else if (id == R.id.item_history) {
            if(currentFrag != FRAG_HISTORY){
                replaceFrag(new HistoryFrag());
                currentFrag = FRAG_HISTORY;
            }
        } else if (id == R.id.item_cart) {
            if(currentFrag != FRAG_CART){
                replaceFrag(new CartFrag());
                currentFrag = FRAG_CART;
            }
        } else if (id == R.id.item_favorite) {
            if(currentFrag != FRAG_FAVORITE){
                replaceFrag(new FavoriteFrag());
                currentFrag = FRAG_FAVORITE;
            }
        } else if (id == R.id.item_logout) {
            // Chuyển về trang đăng nhập
            Intent intent = new Intent(this, DangNhap.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);  // Xóa ngăn xếp Activity trước đó
            startActivity(intent);
            finish();  // Đóng Activity hiện tại
        }

        drawerTrangChung.closeDrawer(GravityCompat.START);
        return true;
    }

    //lựa chọn các item frag để đưa vào phương thức if else trên
    private void replaceFrag(Fragment fragment){
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.frame, fragment);
        fragTrans.commit();
    }
}
