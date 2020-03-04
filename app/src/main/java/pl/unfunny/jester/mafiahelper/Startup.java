package pl.unfunny.jester.mafiahelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import pl.unfunny.jester.mafiahelper.activities.ActionTableActivity;
import pl.unfunny.jester.mafiahelper.activities.ChooseRolesActivity;
import pl.unfunny.jester.mafiahelper.activities.TakeActionActivity;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openChooseRolesActivity(View view) {
        Intent intent = new Intent(this, ChooseRolesActivity.class);
        startActivity(intent);
    }

    public void openActionTableActivity(View view) {
        Intent intent = new Intent(this, ActionTableActivity.class);
        startActivity(intent);
    }

    public void openTakeActionActivity(View view) {
        Intent intent = new Intent(this, TakeActionActivity.class);
        startActivity(intent);
    }
}
