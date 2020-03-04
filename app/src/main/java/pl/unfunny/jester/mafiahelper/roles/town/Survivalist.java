package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Survivalist extends Role {

    public Survivalist() {
        super(
                R.string.survivalist,
                R.string.survivalistShort,
                R.string.survivalistDescription,
                Faction.TOWN,
                6,
                ActionNight.VEST,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.survivalist
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.survivalistFlavour;
    }
}
