package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Arsonist extends Role {

    public Arsonist() {
        super(
                R.string.arsonist,
                R.string.arsonistShort,
                R.string.arsonistDescription,
                Faction.NEUTRAL,
                2,
                ActionNight.ARSON,
                ActionDay.NONE,
                Attack.NONE,
                Defence.BASIC,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.arsonistFlavour;
    }
}
