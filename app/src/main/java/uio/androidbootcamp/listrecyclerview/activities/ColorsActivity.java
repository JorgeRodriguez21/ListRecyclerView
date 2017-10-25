package uio.androidbootcamp.listrecyclerview.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uio.androidbootcamp.listrecyclerview.R;
import uio.androidbootcamp.listrecyclerview.adapters.ColorsRecyclerAdapter;

/**
 * Created by jrodri on 7/7/17.
 */

public class ColorsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_colors)
    protected RecyclerView colorsRecyclerView;

    private List<String> colors;
    private ColorsRecyclerAdapter colorsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ButterKnife.bind(this);
        initializeColorsList();
        initializeAdapter();
    }

    private void initializeColorsList() {
        colors = new ArrayList<>();
        colors.add("ROJO");
        colors.add("AZUL");
        colors.add("AMARILLO");
    }

    private void initializeAdapter() {
        colorsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        colorsRecyclerAdapter = new ColorsRecyclerAdapter(this, colors);
        colorsRecyclerAdapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedColor = (String) v.getTag();
                if (selectedColor != null) {
                    switch (selectedColor) {
                        case "ROJO":
                            colorsRecyclerView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                            break;
                        case "AZUL":
                            colorsRecyclerView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                            break;
                        case "AMARILLO":
                            colorsRecyclerView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
                            break;
                    }
                }
            }
        });
        colorsRecyclerView.setAdapter(colorsRecyclerAdapter);
    }
}
