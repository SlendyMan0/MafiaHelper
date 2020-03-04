package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Veteran extends Role {

    public Veteran() {
        super(
                R.string.veteran,
                R.string.veteranShort,
                R.string.veteranDescription,
                Faction.TOWN,
                4,
                ActionNight.ALERT,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.veteran
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.veteranFlavour;
    }
}
