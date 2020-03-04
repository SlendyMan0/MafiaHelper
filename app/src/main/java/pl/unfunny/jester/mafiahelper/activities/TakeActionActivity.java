package pl.unfunny.jester.mafiahelper.activities;

import android.annotation.SuppressLint;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.datastructures.RoleHistory;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.utility.Helper;

public class TakeActionActivity extends AppCompatActivity {

    private LinearLayout linear_action_container;
    private ImageView image_action_role;
    private TextView text_action_role;
    private TextView text_action_instruction;

    private List<RoleHistory> history;

    private int displayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_action);

        linear_action_container = findViewById(R.id.linear_action_container);
        image_action_role = findViewById(R.id.image_action_role);
        text_action_role = findViewById(R.id.text_action_role);
        text_action_instruction = findViewById(R.id.text_action_instruction);

        history = Helper.initRoleHistory();

        changeDisplayed(displayed);
    }

    private boolean changeDisplayed(int i) {
        if (displayed < history.size()) {
            image_action_role.setImageDrawable(getDrawable(history.get(i).getRoleImage()));
            text_action_role.setText(history.get(i).getRoleName());
            text_action_instruction.setText(history.get(i).getRoleDesc());

            correctActionDisplay(history.get(i), linear_action_container);

            return true;
        } else {
            return false;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void correctActionDisplay(RoleHistory rh, LinearLayout container) {
        View view;

        TextView text_action_flavour;
        TextView text_action_detail;
        TextView text_action_flavour2;
        TextView text_action_detail2;

        switch (rh.getRole().getNight()) {
            case NONE:
            case EXECUTE:
                view = LayoutInflater.from(this).inflate(R.layout.action_none, container, false);

                text_action_flavour = view.findViewById(R.id.text_action_flavour);

                text_action_flavour.setText(rh.getRoleFlavour());

                container.removeAllViews();
                container.addView(view);

                break;

            case BEWITCH:
                view = LayoutInflater.from(this).inflate(R.layout.action_double, container, false);

                text_action_flavour = view.findViewById(R.id.text_action_flavour);
                text_action_detail = view.findViewById(R.id.text_action_detail);
                text_action_flavour2 = view.findViewById(R.id.text_action_flavour2);
                text_action_detail2 = view.findViewById(R.id.text_action_detail2);

                text_action_flavour.setText(rh.getRoleFlavour());
                text_action_flavour2.setText(rh.getRoleFlavour());
                text_action_detail.setText("NaN");
                text_action_detail2.setText("NaN");

                container.removeAllViews();
                container.addView(view);

                break;

            default:
                view = LayoutInflater.from(this).inflate(R.layout.action_basic, container, false);

                text_action_flavour = view.findViewById(R.id.text_action_flavour);
                text_action_detail = view.findViewById(R.id.text_action_detail);

                text_action_flavour.setText(rh.getRoleFlavour());
                text_action_detail.setText("NaN");

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch(event.getAction()) {
                            case (MotionEvent.ACTION_DOWN) :
                                Log.d("DEBUG_TAG","Action was DOWN");
                                return true;
                            case (MotionEvent.ACTION_MOVE) :
                                Log.d("DEBUG_TAG","Action was MOVE");
                                return true;
                            case (MotionEvent.ACTION_UP) :
                                Log.d("DEBUG_TAG","Action was UP");
                                return true;
                            default :
                                return true;
                        }

                    }
                });

                container.removeAllViews();
                container.addView(view);

                break;
        }

    }

    public void confirmAction(View view) {
        changeDisplayed(++displayed);
    }


}
