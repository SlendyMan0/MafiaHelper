package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Nun extends Role {

    public Nun() {
        super(
                R.string.nun,
                R.string.nunShort,
                R.string.nunDescription,
                Faction.TOWN,
                2,
                ActionNight.BLOCK,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.nun
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.nunFlavour;
    }
}
