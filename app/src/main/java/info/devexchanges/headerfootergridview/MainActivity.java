package info.devexchanges.headerfootergridview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class MainActivity extends AppCompatActivity {

    private GridViewWithHeaderAndFooter gridView;
    private ArrayAdapter<Integer> adapter;
    private Integer[] drawablesResource = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.f,
            R.mipmap.e, R.mipmap.g, R.mipmap.h, R.mipmap.i, R.mipmap.j, R.mipmap.k};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridViewWithHeaderAndFooter) findViewById(R.id.grid_view);
        setGridViewHeaderAndFooter();

        adapter = new GridViewAdapter(this, R.layout.item_grid, drawablesResource);
        gridView.setAdapter(adapter);
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    private void setGridViewHeaderAndFooter() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        View headerView = layoutInflater.inflate(R.layout.layout_header, null, false);
        View footerView = layoutInflater.inflate(R.layout.layout_footer, null, false);

        //locate views
        TextView headerText = (TextView)headerView.findViewById(R.id.text);
        TextView footerText = (TextView)footerView.findViewById(R.id.text);

        headerText.setText("GridView Header");
        footerText.setText("GridView Footer");

        headerView.setOnClickListener(onClickListener(0));
        footerView.setOnClickListener(onClickListener(1));

        gridView.addHeaderView(headerView);
        gridView.addFooterView(footerView);
    }

    private View.OnClickListener onClickListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    Toast.makeText(MainActivity.this, "Header Clicked!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Footer Clicked!", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
