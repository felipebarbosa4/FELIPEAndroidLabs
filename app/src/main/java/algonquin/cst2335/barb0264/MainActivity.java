package algonquin.cst2335.barb0264;

/**
 * @author Felipe Barbosa
 * @version 1.0
 * @date 6/20/2023
 */

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.theText);
        EditText et = findViewById(R.id.editTextText);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener( clk -> {
               String password = et.getText().toString();
                if (checkPasswordComplexity(password)) {
                    String successMessage = "Your password meets the requirements";
                    SpannableString spannableString = new SpannableString(successMessage);
                    ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.GREEN);
                    spannableString.setSpan(colorSpan, 0, successMessage.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    tv.setText(spannableString);
                } else {
                    String errorMessage = "You shall not pass!";
                    SpannableString spannableString = new SpannableString(errorMessage);
                    ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                    spannableString.setSpan(colorSpan, 0, errorMessage.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    tv.setText(spannableString);
                }
        });
    }

    /** Checks for Upper Case letter, a lower case letter, a number, and a special symbol (#$%^&*!@?)
     *
     * @param pw The String object we are checking
     * @return Returns true if the password is complex enough
     *
     */
    @SuppressLint("SuspiciousIndentation")
    boolean checkPasswordComplexity(String pw) {
        if (pw == null || pw.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a password", Toast.LENGTH_SHORT).show();
            return false;
        }

        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        List<Character> splitted_password = new ArrayList<>();
        for (int each_character = 0; each_character < pw.length(); each_character++) {
            char ch = pw.charAt(each_character);
            splitted_password.add(ch);
        }

        for (char ch : splitted_password) {
            if (isSpecialCharacter(ch)) {
                foundSpecial = true;
            } else if (Character.isUpperCase(ch)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                foundLowerCase = true;
            } else if (Character.isDigit(ch)) {
                foundNumber = true;
            }

            if (foundSpecial && foundUpperCase && foundLowerCase && foundNumber) {
                break;
            }
        }

        if(!foundUpperCase) {
            Toast.makeText(MainActivity.this, "Missing UpperCase", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if( ! foundLowerCase) {
            Toast.makeText(MainActivity.this, "Missing LowerCase", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if( ! foundNumber) {
            Toast.makeText(MainActivity.this, "Missing Number", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(! foundSpecial) {
        Toast.makeText(MainActivity.this, "Missing Special Character", Toast.LENGTH_SHORT).show();
        return false;
        }
        else
            Toast.makeText(MainActivity.this, "Your password meets the requirements", Toast.LENGTH_SHORT).show();
            return true; //only get here if they're all true

    }
    /** Check for (#$%^&*!@?)
     *
     * @param c The character object we are checking
     * @return Returns true if the password has one special character
     *
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '?':
            case '*':
            case '$':
            case '%':
            case '^':
            case '&':
            case '!':
            case '@':
                return true;
            default:
                return false;
        }
    }
}