package algonquin.cst2335.barb0264.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

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
        //listen for changes to MutableLiveData

        
        model.checkboxState.observe(this, (newValue) -> {
            variableBinding.theCheckbox.setChecked((newValue));
            variableBinding.theSwitch.setChecked((newValue));
            variableBinding.theRadioButton.setChecked((newValue));
        });

        model.switchState.observe(this, (newValue) -> {

        });

        model.radioButtonState.observe(this, (newValue) -> {

        });


        // it has to have 2 parameters a,b because the original one has buttonView and ischecked.
        variableBinding.theCheckbox.setOnCheckedChangeListener((btn, isChecked) -> {
            model.checkboxState.postValue(isChecked);
            Toast.makeText(this, "CheckBox state: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        variableBinding.theSwitch.setOnCheckedChangeListener((btn, isChecked) -> {
            model.checkboxState.postValue(isChecked);
            Toast.makeText(this, "Switch state: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        variableBinding.theRadioButton.setOnCheckedChangeListener((btn, isChecked) -> {
            model.checkboxState.postValue(isChecked);
            Toast.makeText(this, "RadioButton state: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        variableBinding.myImageView.setOnClickListener((click) -> {

                Toast.makeText(this, "ImageView clicked", Toast.LENGTH_SHORT).show();
            }
        );

        // ImageButton click listener
        variableBinding.myImageButton.setOnClickListener((click) -> {
                // Handle ImageButton click event
                int width = click.getWidth();
                int height = click.getHeight();
                String message = "The width = " + width + " and height = " + height;
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });


        variableBinding.theText.setText(model.theText); // compoungWidgets

        variableBinding.theButton.setOnClickListener((click) -> {

            model.theText = "You clicked me!!";

            variableBinding.theText.setText(model.theText);

        });
    }
}