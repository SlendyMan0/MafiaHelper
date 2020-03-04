package pl.unfunny.jester.mafiahelper.activities;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.adapters.RoleChooserAdapter;
import pl.unfunny.jester.mafiahelper.listeners.RoleCounterListener;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;
import pl.unfunny.jester.mafiahelper.roles.mafia.TrapMaster;
import pl.unfunny.jester.mafiahelper.roles.mafia.Godfather;
import pl.unfunny.jester.mafiahelper.roles.mafia.Mafioso;
import pl.unfunny.jester.mafiahelper.roles.mafia.Poisoner;
import pl.unfunny.jester.mafiahelper.roles.mafia.Prostitute;
import pl.unfunny.jester.mafiahelper.roles.neutral.Accuser;
import pl.unfunny.jester.mafiahelper.roles.neutral.Amnesiac;
import pl.unfunny.jester.mafiahelper.roles.neutral.Arsonist;
import pl.unfunny.jester.mafiahelper.roles.neutral.Jester;
import pl.unfunny.jester.mafiahelper.roles.neutral.SerialKiller;
import pl.unfunny.jester.mafiahelper.roles.neutral.Witch;
import pl.unfunny.jester.mafiahelper.roles.neutral.Yandere;
import pl.unfunny.jester.mafiahelper.roles.town.Bodyguard;
import pl.unfunny.jester.mafiahelper.roles.town.Detective;
import pl.unfunny.jester.mafiahelper.roles.town.Doctor;
import pl.unfunny.jester.mafiahelper.roles.town.Judge;
import pl.unfunny.jester.mafiahelper.roles.town.Nun;
import pl.unfunny.jester.mafiahelper.roles.town.Survivalist;
import pl.unfunny.jester.mafiahelper.roles.town.Veteran;
import pl.unfunny.jester.mafiahelper.roles.town.Vigilante;
import pl.unfunny.jester.mafiahelper.utility.Converter;
import pl.unfunny.jester.mafiahelper.utility.GridSpacingItemDecoration;
import pl.unfunny.jester.mafiahelper.utility.Helper;

@SuppressWarnings("FieldCanBeLocal")
public class ChooseRolesActivity extends AppCompatActivity implements RoleCounterListener {

    private LinearLayout linear_factions;
    private LinearLayout linear_counter;

    private List<RecyclerView> recyclers;
    private List<RoleChooserAdapter> adapters;
    private List<TextView> counters;
    private List<Integer> counterAmount;

    private List<Role> chosenRoles;
    private List<String> factionNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_roles);

        linear_factions = findViewById(R.id.linear_factions);
        linear_counter = findViewById(R.id.linear_counter);

        recyclers = new ArrayList<>();
        adapters = new ArrayList<>();
        counters = new ArrayList<>();
        counterAmount = new ArrayList<>();

        List<Role> roles = Helper.initRoles();

        int factionCount = 0;
        factionNames = new ArrayList<>();

        for (Role r: roles) {
            if (!factionNames.contains(r.getFaction().factionName())) {
                factionNames.add(r.getFaction().factionName());

                factionCount++;
            }
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int space = (int)(getResources().getDimension(R.dimen.role_image_size) +
                getResources().getDimension(R.dimen.role_image_margin) +
                getResources().getDimension(R.dimen.role_image_holder_margin));
        int spanCount = (int) Math.floor(size.x / space);
        space = size.x - space * 3 - 2 * (int) getResources().getDimension(R.dimen.role_recycler_padding);

        for (int i = 0; i < factionCount; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.faction_container, linear_factions, false);

            List<Role> factionRoles = new ArrayList<>();
            for (int j = 0; j < roles.size(); j++) {
                if (roles.get(j).getFaction().factionName().equals(factionNames.get(i))) {
                    factionRoles.add(roles.get(j));
                }
            }

            TextView text_faction = view.findViewById(R.id.text_faction);

            text_faction.setText(factionNames.get(i));

            RecyclerView recycler_faction = view.findViewById(R.id.recyler_faction);
            RoleChooserAdapter adapter = new RoleChooserAdapter(this, factionRoles);

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, spanCount);
            RecyclerView.ItemDecoration itemDecoration = new GridSpacingItemDecoration(spanCount, space);

            recycler_faction.setLayoutManager(layoutManager);
            recycler_faction.addItemDecoration(itemDecoration);
            recycler_faction.setAdapter(adapter);
            recycler_faction.setNestedScrollingEnabled(false);

            linear_factions.addView(view);

            recyclers.add(recycler_faction);
            adapters.add(adapter);

            view = LayoutInflater.from(this).inflate(R.layout.faction_counter, linear_counter, false);

            TextView text_counter_faction = view.findViewById(R.id.text_counter_faction);
            TextView text_counter_amount = view.findViewById(R.id.text_counter_amount);

            text_counter_faction.setText(factionNames.get(i));
            text_counter_amount.setText("0");

            linear_counter.addView(view);

            counters.add(text_counter_amount);
            counterAmount.add(0);
        }

        View view = LayoutInflater.from(this).inflate(R.layout.faction_counter, linear_counter, false);

        TextView text_counter_faction = view.findViewById(R.id.text_counter_faction);
        TextView text_counter_amount = view.findViewById(R.id.text_counter_amount);

        text_counter_faction.setText(R.string.all);
        text_counter_amount.setText("0");

        linear_counter.addView(view);

        counters.add(text_counter_amount);
        counterAmount.add(0);
    }

    public void confirmRoles(View view) {
        chosenRoles = new ArrayList<>();

        for (int i = 0; i < adapters.size(); i++) {
            chosenRoles.addAll(adapters.get(i).getSelectedRoles());
        }

        Toast.makeText(this, "Selected roles: " + chosenRoles.size(), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onRoleTap(boolean selected, Faction faction) {
        int index = factionNames.indexOf(faction.factionName());

        if (selected) {
            counterAmount.set(index, counterAmount.get(index) + 1);
            counterAmount.set(factionNames.size(), counterAmount.get(factionNames.size()) + 1);
        } else {
            counterAmount.set(index, counterAmount.get(index) - 1);
            counterAmount.set(factionNames.size(), counterAmount.get(factionNames.size()) - 1);
        }

        counters.get(index).setText("" + counterAmount.get(index));
        counters.get(factionNames.size()).setText("" + counterAmount.get(factionNames.size()));
    }
}
