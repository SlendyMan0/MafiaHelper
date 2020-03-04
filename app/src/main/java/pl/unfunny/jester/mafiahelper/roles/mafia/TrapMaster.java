package pl.unfunny.jester.mafiahelper.roles.mafia;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class TrapMaster extends Role {

    public TrapMaster() {
        super(
                R.string.trapmaster,
                R.string.trapmasterShort,
                R.string.trapmasterDescription,
                Faction.MAFIA,
                3,
                ActionNight.TRAP,
                ActionDay.NONE,
                Attack.NONE,
                Defence.BASIC,
                R.drawable.trapmaster
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.trapmasterFlavour;
    }
}
