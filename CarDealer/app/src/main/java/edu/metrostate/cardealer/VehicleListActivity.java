package edu.metrostate.cardealer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class VehicleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);
        setContentView(R.layout.activity_dealer_list);
        findViewById(R.id.Export_json_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DealerTrackerApplication)getApplication()).exportVehicleList("JSON");
            }
        });


        ListView lv = findViewById(R.id.dealer_list);

        lv.setAdapter(new DealerAdapter(this,
                ((DealerTrackerApplication)getApplication()).getDealerList()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("itemClick", String.valueOf(i));
                Dealer dealer = ((DealerTrackerApplication) getApplication()).getDealerList().get(i);
                Intent intent = new Intent(DealerListActivity.this, DealerActivity.class);
                intent.putExtra("dealerId", dealer.getDealerId());
                startActivity(intent);
            }
        });

    }

        // Get the application instance from the activity
        CarDealerApplication app = (CarDealerApplication) getApplication();

        // Create an adapter for the list view
        VehicleAdapter adapter = new VehicleAdapter(this, app.getVehicleList());

        // Find the list view and add the adapter
        ListView vehicleList = ((ListView)findViewById(R.id.vehicle_list));
        vehicleList.setAdapterl(adapter);

        vehicleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog(adapter.getItem(position));
            }
        });


    }

    public void showDialog(Vehicle vehicle) {

        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("My alert")
                .setCancelable(false)
                .setTitle("Vehicle ID: " + vehicle.getId())
                .setMessage("Model: " + vehicle.getModel())
                .setPositiveButton( "OK", (dialog1, id) -> dialog1.dismiss()).create();

        dialog.show();



    }
}