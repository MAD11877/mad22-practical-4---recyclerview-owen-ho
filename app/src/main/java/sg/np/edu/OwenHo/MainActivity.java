package sg.np.edu.OwenHo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user1 = new User("Owen","FI Student",1,false);
        //Log.d(TAG, "ABCDE "+user1.name);

        Intent i = getIntent();

        TextView nameTV = findViewById(R.id.textView);
        TextView descTV = findViewById(R.id.textView2);
        Button followButton = findViewById(R.id.followBtn);
        Button messageButton = findViewById(R.id.msgBtn);

        nameTV.setText(user1.name + " " + i.getIntExtra("key",0));
        descTV.setText(user1.description);
        if(user1.followed){
            followButton.setText("Unfollow");
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.followed){
                    user1.followed = false;
                    followButton.setText("Follow");
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                else{
                    user1.followed = true;
                    followButton.setText("Unfollow");
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                }
                //Log.d(TAG, "ABCDE "+user1.followed);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(i);
            }
        });
    }
}