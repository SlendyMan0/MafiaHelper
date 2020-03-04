package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Detective extends Role {

    public Detective() {
        super(
                R.string.detective,
                R.string.detectiveShort,
                R.string.detectiveDescription,
                Faction.TOWN,
                0,
                ActionNight.INVESTIGATE,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.detective
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.detectiveFlavour;
    }
}
