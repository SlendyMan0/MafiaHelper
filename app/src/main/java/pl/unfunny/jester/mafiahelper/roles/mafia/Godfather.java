package pl.unfunny.jester.mafiahelper.roles.mafia;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Godfather extends Role {

    public Godfather() {
        super(
                R.string.godfather,
                R.string.godfatherShort,
                R.string.godfatherDescription,
                Faction.MAFIA,
                0,
                ActionNight.CHOOSE_KILL,
                ActionDay.VENDETTA,
                Attack.NONE,
                Defence.NONE,
                R.drawable.godfather
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.godfatherFlavour;
    }
}
