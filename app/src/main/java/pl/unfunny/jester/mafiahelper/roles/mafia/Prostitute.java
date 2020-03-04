package pl.unfunny.jester.mafiahelper.roles.mafia;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Prostitute extends Role {

    public Prostitute() {
        super(
                R.string.prostitute,
                R.string.prostituteShort,
                R.string.prostituteDescription,
                Faction.MAFIA,
                1,
                ActionNight.BLOCK,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.prostitiute
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.prostituteFlavour;
    }
}
