package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Bodyguard extends Role {

    public Bodyguard() {
        super(
                R.string.bodyguard,
                R.string.bodyguardShort,
                R.string.bodyguardDescription,
                Faction.NEUTRAL,
                3,
                ActionNight.PROTECT,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.bodyguard
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.bodyguardFlavour;
    }
}
