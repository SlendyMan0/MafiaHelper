package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Witch extends Role {

    public Witch() {
        super(
                R.string.witch,
                R.string.witchShort,
                R.string.witchDescription,
                Faction.NEUTRAL,
                0,
                ActionNight.BEWITCH,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.witchFlavour;
    }
}
