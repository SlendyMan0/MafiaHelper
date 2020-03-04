package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Judge extends Role {

    public Judge() {
        super(
                R.string.judge,
                R.string.judgeShort,
                R.string.judgeDescription,
                Faction.TOWN,
                7,
                ActionNight.NONE,
                ActionDay.JUDGE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.judge
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.judgeFlavour;
    }
}
