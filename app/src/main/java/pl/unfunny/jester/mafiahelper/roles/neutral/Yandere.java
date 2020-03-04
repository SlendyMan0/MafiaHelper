package pl.unfunny.jester.mafiahelper.roles.neutral;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Yandere extends Role {

    public Yandere() {
        super(
                R.string.yandere,
                R.string.yandereShort,
                R.string.yandereDescription,
                Faction.NEUTRAL,
                6,
                ActionNight.FALL_IN_LOVE,
                ActionDay.NONE,
                Attack.UNSTOPPABLE,
                Defence.BASIC,
                R.drawable.ic_launcher_background
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.yandereFlavour;
    }
}
