package algonquin.cst2335.barb0264.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.CompoundButton;

import algonquin.cst2335.barb0264.data.MainActivityModel;
import algonquin.cst2335.barb0264.databinding.ActivityMainBinding; // 6
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding; // 6

    MainActivityModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainActivityModel.class);


        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot()); // This recalculates the width rotate phone

        // it has to have 2 parameters a,b because the original one has buttonView and ischecked.
        variableBinding.theCheckbox.setOnCheckedChangeListener( (btn, isChecked) -> { } );

        variableBinding.theText.setText (model.theText); // compoungWidgets

        variableBinding.theButton.setOnClickListener( ( click ) -> {

            model.theText = "You clicked me!!";

            variableBinding.theText.setText(model.theText);

        });
    }
}