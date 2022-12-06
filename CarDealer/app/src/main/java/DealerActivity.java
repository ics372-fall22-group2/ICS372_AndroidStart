import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class DealerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Dealer);

        ListView lv = findViewById(R.id.dealerlist);



        Bundle extras = getIntent().getExtras();
        String dealerId = findViewById(R.id.dealerId);
        String vehicleId = findViewById(R.id.vehicleId);

        if (extras != null) {
            vehicleId = extras.getString("dealerId");
            lv.setAdapter(new VehcleAdapter(dealerActivity.this,
                    ((DealerTrackerApplication)getApplication()).showVehicleByDealer(dealerId)));
            tvVehicleId.setText("Dealer " + dealerId);
        } else {
            dealerId.setText("Invalid dealer");
        }
    }

