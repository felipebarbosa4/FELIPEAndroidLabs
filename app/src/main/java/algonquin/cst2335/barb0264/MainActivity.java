package algonquin.cst2335.barb0264;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // 2
import android.widget.EditText;
import android.widget.TextView; // 1

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 3
        EditText theEdit = findViewById(R.id.theEdittext); // 4

        TextView theText = findViewById(R.id.theText); // 1


        // The above snippet creates an instance of View.OnClickListener
        // and wires the listener to the button using setOnClickListener(View.OnClickListener).
        // As a result, the system executes the code you write in onClick(View) after the
        // user presses the button.
        Button b = findViewById(R.id.theButton); // 2
        b.setOnClickListener(new View.OnClickListener() { // 5
            @Override
            public void onClick(View v) {

                String words = theEdit.getText().toString(); // return what's in the EditText
                // this changes what is in the textView
                theText.setText(words); //6
            }
        });
        // End of Click Listerner


        String editString = theEdit.getText().toString();
        theText.setText( "Your edit text has: " + editString);

        }
    }
