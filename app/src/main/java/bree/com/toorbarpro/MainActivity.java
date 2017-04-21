package bree.com.toorbarpro;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toorbar = (Toolbar) findViewById(R.id.toorbar);
        setSupportActionBar(toorbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            //显示导航栏
            actionBar.setDisplayHomeAsUpEnabled(true);
              //显示导航栏图标
            actionBar.setHomeAsUpIndicator(R.drawable.navigation);
        }

        drawerlayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        //默认选中条目
        navView.setCheckedItem(R.id.nav1);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav1:
                        Toast.makeText(MainActivity.this, "nav1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav2:
                        Toast.makeText(MainActivity.this, "nav2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav3:
                        Toast.makeText(MainActivity.this, "nav3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav4:
                        Toast.makeText(MainActivity.this, "nav4", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav5:
                        Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_SHORT).show();
                        drawerlayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toorbar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "item4", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerlayout.openDrawer(GravityCompat.START);
                Log.d("MainActivity", "home");
                break;
        }
        return  true;
    }
}
