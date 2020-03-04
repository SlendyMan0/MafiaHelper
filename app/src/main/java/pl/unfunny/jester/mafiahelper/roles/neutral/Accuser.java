package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Accuser extends Role {

    public Accuser() {
        super(
                R.string.accuser,
                R.string.accuserShort,
                R.string.accuserDescription,
                Faction.NEUTRAL,
                3,
                ActionNight.ACCUSE,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.accuserFlavour;
    }
}
