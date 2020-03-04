package pl.unfunny.jester.mafiahelper.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.datastructures.RoleHistory;
import pl.unfunny.jester.mafiahelper.roles.Role;
import pl.unfunny.jester.mafiahelper.utility.Helper;
import pl.unfunny.jester.mafiahelper.utility.ScrambleId;

@SuppressWarnings("FieldCanBeLocal")
public class ActionTableActivity extends AppCompatActivity {

    private TableLayout table_actions;
    private TableRow row_header;

    private List<TableRow> rows;

    private int day = 0;
    private int night = 0;
    private List<RoleHistory> history;

    private String selectedId = null;
    private Integer idSource = null;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_table);

        table_actions = findViewById(R.id.table_actions);
        row_header = findViewById(R.id.row_header);

        rows = new ArrayList<>();
        history = new ArrayList<>();

        //Intent intent = getIntent();

        List<Role> roles = Helper.initRoles(); //TODO replace with actual code
        ScrambleId scramble = new ScrambleId(roles.size());
        for (int i = 0; i < roles.size(); i++) {
            RoleHistory rh = new RoleHistory();

            rh.setRole(roles.get(i));
            rh.setId(scramble.get(i));

            history.add(rh);
        }

        TextView header_number = row_header.findViewById(R.id.text_row_number);

        header_number.setText(R.string.roleNumber);

        for (int i = 0; i < history.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.role_row, table_actions, false);

            TableRow row_actions = view.findViewById(R.id.row_actions);

            rows.add(row_actions);

            ImageView image_row_role = view.findViewById(R.id.image_row_role);
            TextView text_row_short_name = view.findViewById(R.id.text_row_short_name);
            TextView text_row_number = view.findViewById(R.id.text_row_number);

            image_row_role.setImageResource(history.get(i).getRoleImage());
            text_row_short_name.setText(history.get(i).getRoleShort());
            text_row_number.setText(history.get(i).getId());
            text_row_number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (day == 0 && night == 0 && v.getParent() instanceof TableRow) {
                        int current = rows.indexOf(v.getParent());

                        if (selectedId != null) {
                            if (current != idSource) {
                                String temp = history.get(current).getId();

                                history.get(current).setId(selectedId);
                                history.get(idSource).setId(temp);

                                TextView t1 = rows.get(current).findViewById(R.id.text_row_number);
                                TextView t2 = rows.get(idSource).findViewById(R.id.text_row_number);

                                t1.setText(history.get(current).getId());
                                t2.setText(history.get(idSource).getId());

                                selectedId = null;
                                idSource = null;
                            }
                        } else {
                            idSource = current;
                            selectedId = history.get(idSource).getId();
                        }
                    }
                }
            });

            table_actions.addView(view);
        }
    }

    @SuppressLint("SetTextI18n")
    public void newNight(View view) {
        night++;

        View cell = LayoutInflater.from(this).inflate(R.layout.role_cell, row_header, false);

        TextView text_row_cell = cell.findViewById(R.id.text_row_cell);

        text_row_cell.setText("N" + night);
        text_row_cell.setBackgroundResource(R.color.grey_background_darker);

        row_header.addView(cell);

        for (int i = 0; i < rows.size(); i++) {
            cell = LayoutInflater.from(this).inflate(R.layout.role_cell, rows.get(i), false);

            rows.get(i).addView(cell);
        }
    }
}
