package edu.metrostate.cardealer.entity.vehicle;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;

import java.util.Date;

import edu.metrostate.cardealer.MainActivity;
import edu.metrostate.cardealer.R;
import edu.metrostate.cardealer.VehicleListActivity;
import edu.metrostate.cardealer.entity.dealer.Dealer;


public class VehicleActivity extends AppCompatActivity {
    public String vehicleId;
    TextView  vehicleModel;
    TextView vehicleType;
    Button btDeleteVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Bundle extras = getIntent().getExtras();

        this.vehicleId = findViewById(R.id.vehicleId);
        this.vehicleModel = findViewById(R.id.vehicleModel);
        this.btDeleteVehicle = findViewById(R.id.btDeleteVehicle);

        if (extras != null) {
            vehicleId = extras.getString("vehicleId");
            Vehicle vehicle = ((DealerTrackerApplication)getApplication()).getVehicleType(vehicleId);

            if (vehicle == null) {
                vehicleModel.setText("Invalid vehicle");
                btDeleteVehicle.setVisibility(View.GONE);
            } else {
                Dealer dealer = ((DealerTrackerApplication)getApplication()).getDealerId(Dealer.getvehicleId());
                vehicleModel.setText("Vehicle " + vehicle.getModel());
                String name;
                if (dealer == null) {
                    name = "None";
                } else {
                    name = dealer.getName();
                }
                String vehicleType = getVehicleType(vehicle, name);
                Vehicle.VehicleType.setText(vehicleType);
            }
        } else {
            vehicleModel.setText("Invalid vehicle");
            btDeleteVehicle.setVisibility(View.GONE);
        }
    }

    public void backHome (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void backVehicleList(View view) {
        Intent intent = new Intent(this, VehicleListActivity.class);
        startActivity(intent);
    }
}