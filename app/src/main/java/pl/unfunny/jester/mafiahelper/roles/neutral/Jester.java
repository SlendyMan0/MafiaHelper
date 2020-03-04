package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Jester extends Role {

    public Jester() {
        super(
                R.string.jester,
                R.string.jesterShort,
                R.string.jesterDescription,
                Faction.NEUTRAL,
                4,
                ActionNight.NONE,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.jesterFlavour;
    }
}
