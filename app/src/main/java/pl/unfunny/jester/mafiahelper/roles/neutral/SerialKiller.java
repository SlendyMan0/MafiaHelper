package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class SerialKiller extends Role {

    public SerialKiller() {
        super(
                R.string.serialkiller,
                R.string.serialkillerShort,
                R.string.serialkillerDescription,
                Faction.NEUTRAL,
                1,
                ActionNight.MURDER,
                ActionDay.NONE,
                Attack.POWERFUL,
                Defence.BASIC,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.serialkillerFlavour;
    }
}
