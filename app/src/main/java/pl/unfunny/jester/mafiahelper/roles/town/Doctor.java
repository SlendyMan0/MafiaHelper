package pl.unfunny.jester.mafiahelper.roles.town;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.roles.ActionDay;
import pl.unfunny.jester.mafiahelper.roles.ActionNight;
import pl.unfunny.jester.mafiahelper.roles.Attack;
import pl.unfunny.jester.mafiahelper.roles.Defence;
import pl.unfunny.jester.mafiahelper.roles.Faction;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class Doctor extends Role {

    public Doctor() {
        super(
                R.string.doctor,
                R.string.doctorShort,
                R.string.doctorDescription,
                Faction.TOWN,
                1,
                ActionNight.HEAL,
                ActionDay.NONE,
                Attack.NONE,
                Defence.NONE,
                R.drawable.doctor
        );
    }

    @Override
    public int getRoleFlavour() {
        return R.string.doctorFlavour;
    }
}
