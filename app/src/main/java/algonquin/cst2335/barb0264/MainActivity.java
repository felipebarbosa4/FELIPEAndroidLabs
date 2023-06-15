package algonquin.cst2335.barb0264;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.File;

import algonquin.cst2335.barb0264.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    protected ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(TAG, "OnCreate(). First function that gets created when an application is launched");


       binding = ActivityMainBinding.inflate(getLayoutInflater());

       setContentView( binding.getRoot() );


       // where you can save files
        File myDir = getFilesDir();
        String path = myDir.getAbsolutePath();

        // CREATE A DIRECTORY
        SharedPreferences savedprefs = getSharedPreferences("MyFileName", Context.MODE_PRIVATE);

        // GET AN EDITOR
        SharedPreferences.Editor edit = savedprefs.edit();





savedprefs.getString("NAME", "default");

       binding.loginButton.setOnClickListener( (v) -> {

           Log.w(TAG, "You Clicked the Button");

           // which page do i go to:   leaving here       going to SecondActivity
           Intent nextPage = new Intent(this, SecondActivity.class  );
           //when we use this intent object we can send some data

           String whatIsTyped = binding.emailText.getText().toString();
           nextPage.putExtra("EMAIL", whatIsTyped);

           edit.putString("PHONENUMBER", "6137274723");
           edit.putInt("AGE", 26);
           edit.putString("NAME", "Felipe");
           edit.putString("EMAIL", whatIsTyped);
           edit.apply();
           //save to disk
           edit.commit();

           Intent intent = new Intent(Intent.ACTION_DIAL);
           intent.setData(Uri.parse("tel:" + "6137274723"));
//           //go to another page
           startActivity(nextPage); // carries all the data to the next page

       } );
    }
    @Override// the app is now visible on screen, not listening for clicks
    protected void onStart() {
        Log.w(TAG, "onStart(). The application is now visible on screen.");
        super.onStart();
    }
    @Override // garbage collected, app is gone
    protected void onDestroy() {
        Log.w(TAG, "onDestroy(). Any memory used by the application is freed.\n" +
                "Starting new Activities.");
        super.onDestroy();
    }

    @Override // leaving the screen, no longer listening for input
    protected void onPause() {
        Log.w(TAG, "onPause(). The application no longer responds to user input.");
        super.onPause();
    }
    @Override
    protected void onResume() {
        Log.w(TAG, "onResume(). The application is now responding to user input.");
        super.onResume();
    }
    @Override
    protected void onStop() {
        Log.w(TAG, "onStop(). The application is no longer visible.");
        super.onStop();
    }

}
