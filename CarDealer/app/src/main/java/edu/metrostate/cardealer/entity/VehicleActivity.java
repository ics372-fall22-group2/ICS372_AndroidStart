package edu.metrostate.cardealer.entity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.metrostate.cardealer.MainActivity;
import edu.metrostate.cardealer.R;
import edu.metrostate.cardealer.entity.dealer.Dealer;
import edu.metrostate.cardealer.entity.vehicle.Vehicle;

public class AddVehicleActivity extends AppCompatActivity {

    Button btAddVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
    }



    public void addVehicle (View view, Vehicle vehicle) {
        Dialog dialog;
        Dealer dealer = new Dealer();
            dealer.addVehicle(vehicle);

            if(dealer.getDealerVehicles().contains(vehicle)){
                dialog = new AlertDialog.Builder(this).setTitle("adding vehicle").setCancelable(false)
                        .setMessage(vehicle.getVehicleId() + " Vehicle was added to " + dealer.getName())
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }

                                }
            }
        }
    }
    public void backHome (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}