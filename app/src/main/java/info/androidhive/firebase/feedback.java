package info.androidhive.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//Feedback class sends a mail to developer reggarding any changes required for the betterment of app
public class feedback extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

    }
    public void onSend(View view)
    {

        editText=(EditText) findViewById(R.id.feed);
        String msg=editText.getText().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mohitvermalmpk@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback of Mbook");
        i.putExtra(Intent.EXTRA_TEXT , msg);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(feedback.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
