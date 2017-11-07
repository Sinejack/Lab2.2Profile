package my.edu.tarc.lab22profile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "my.edu.tarc.lab22profile.name";
    public static final String PROFILE_EMAIL = "my.edu.tarc.lab22profile.email";
    private TextView textViewName, textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName=(TextView)findViewById(R.id.textViewName);
        textViewEmail=(TextView)findViewById(R.id.textViewEmail);

    }

    public void updateProfile(View view)
    {
        //Explicit intent
        Intent intent=new Intent(this,ProfileActivity.class);
        startActivityForResult(intent,REQUEST_PROFILE_UPDATE);
    }

    public void visitTARUC(View v)
    {
        String url="https://www.tarc.edu.my";
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    //Display main menu
    public void showMain(View v)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }
    //Connect to phone
    public void showDial(View v)
    {
        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"0123456789"));
        startActivity(intent);
    }
    public void showSendTo(View view)
    {
        Intent intent=new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:"+"seekt@tarc.edu.my"));
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*
        Request code= a unique code to identify an intent
        Result code = result of an intent call; either ok or cancel
        data = the actual data returned by an intent
        */
        if(requestCode==REQUEST_PROFILE_UPDATE)
        {
            String name, email;
            name=data.getStringExtra(PROFILE_NAME);
            email=data.getStringExtra(PROFILE_EMAIL);

            textViewName.setText(getString(R.string.name)+name);
            textViewEmail.setText(getString(R.string.email)+email);
        }
    }
}
