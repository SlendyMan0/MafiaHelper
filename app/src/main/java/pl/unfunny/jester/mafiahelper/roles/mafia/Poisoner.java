package pl.unfunny.jester.mafiahelper.roles.mafia;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Poisoner extends Role {

    public Poisoner() {
        super(
                R.string.poisoner,
                R.string.poisonerShort,
                R.string.poisonerDescription,
                Faction.MAFIA,
                2,
                ActionNight.POISON,
                ActionDay.NONE,
                Attack.POWERFUL,
                Defence.BASIC,
                R.drawable.poisoner
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.poisonerFlavour;
    }
}
