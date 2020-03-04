package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Vigilante extends Role {

    public Vigilante() {
        super(
                R.string.vigilante,
                R.string.vigilanteShort,
                R.string.vigilanteDescription,
                Faction.TOWN,
                5,
                ActionNight.VIGIL,
                ActionDay.NONE,
                Attack.BASIC,
                Defence.NONE,
                R.drawable.vigilante
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.vigilanteFlavour;
    }
}
