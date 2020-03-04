package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Amnesiac extends Role {

    public Amnesiac() {
        super(
                R.string.amnesiac,
                R.string.amnesiacShort,
                R.string.amnesiacDescription,
                Faction.NEUTRAL,
                5,
                ActionNight.REMEMBER,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.amnesiacFlavour;
    }
}
