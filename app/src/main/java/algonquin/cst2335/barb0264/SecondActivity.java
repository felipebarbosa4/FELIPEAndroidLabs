package algonquin.cst2335.barb0264;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import algonquin.cst2335.barb0264.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;
    ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        //loads the XML file /res/layout/activity_second.xml
        setContentView(binding.getRoot());

        ImageView profileImage;
        profileImage = binding.imageView;


        Intent nextPage = getIntent(); //return the Intent that got us here from FirstPage

        //should be variables in nextPage:

        //null if EMAIL is not found because is the default for STRING
        String EMAIL = nextPage.getStringExtra("EMAIL"); // get the value of EMAIL variable
        String day = nextPage.getStringExtra("DAY");
        int age = nextPage.getIntExtra("AGE", 0);
        String phoneNumber = binding.editTextPhone.getText().toString();



        int something = nextPage.getIntExtra("SOMETHING", 0); // default if for when SOMETHING is not there


        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ActivityResultLauncher <Intent> cameraResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override

                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == Activity.RESULT_OK) {

                            Intent data = result.getData();
                            Bitmap thumbnail = data.getParcelableExtra("data");
                            profileImage.setImageBitmap( thumbnail );

                        }
                    }
                });

        binding.textView2.setText("Welcome back " + EMAIL);


        binding.changePictureButton.setOnClickListener( (v) -> {


            cameraResult.launch(cameraIntent);
        });



        binding.goBackButton.setOnClickListener( (v) -> {

            //opposite of startActivity()
            finish(); //go back to the previous


        });

        binding.callNumberButton.setOnClickListener((v) -> {

            String enteredPhoneNumber = binding.editTextPhone.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + enteredPhoneNumber));
            startActivity(callIntent);
        });



    }
}