package pl.unfunny.jester.mafiahelper.roles.mafia;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Mafioso extends Role {

    public Mafioso() {
        super(
                R.string.mafioso,
                R.string.mafiosoShort,
                R.string.mafiosoDescription,
                Faction.MAFIA,
                99,
                ActionNight.EXECUTE,
                ActionDay.NONE,
                Attack.BASIC,
                Defence.NONE,
                R.drawable.mafioso
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.mafiosoFlavour;
    }
}
