package pl.unfunny.jester.mafiahelper.utility;

import java.util.ArrayList;
import java.util.List;

import pl.unfunny.jester.mafiahelper.datastructures.RoleHistory;
import pl.unfunny.jester.mafiahelper.roles.Role;
import pl.unfunny.jester.mafiahelper.roles.mafia.Godfather;
import pl.unfunny.jester.mafiahelper.roles.mafia.Mafioso;
import pl.unfunny.jester.mafiahelper.roles.mafia.Poisoner;
import pl.unfunny.jester.mafiahelper.roles.mafia.Prostitute;
import pl.unfunny.jester.mafiahelper.roles.mafia.TrapMaster;
import pl.unfunny.jester.mafiahelper.roles.neutral.Accuser;
import pl.unfunny.jester.mafiahelper.roles.neutral.Amnesiac;
import pl.unfunny.jester.mafiahelper.roles.neutral.Arsonist;
import pl.unfunny.jester.mafiahelper.roles.neutral.Jester;
import pl.unfunny.jester.mafiahelper.roles.neutral.SerialKiller;
import pl.unfunny.jester.mafiahelper.roles.neutral.Witch;
import pl.unfunny.jester.mafiahelper.roles.neutral.Yandere;
import pl.unfunny.jester.mafiahelper.roles.town.Bodyguard;
import pl.unfunny.jester.mafiahelper.roles.town.Detective;
import pl.unfunny.jester.mafiahelper.roles.town.Doctor;
import pl.unfunny.jester.mafiahelper.roles.town.Judge;
import pl.unfunny.jester.mafiahelper.roles.town.Nun;
import pl.unfunny.jester.mafiahelper.roles.town.Survivalist;
import pl.unfunny.jester.mafiahelper.roles.town.Veteran;
import pl.unfunny.jester.mafiahelper.roles.town.Vigilante;

public class Helper {

    public static List<Role> initRoles() {
        List<Role> roles = new ArrayList<>();

        roles.add(new Godfather());
        roles.add(new Mafioso());
        roles.add(new Prostitute());
        roles.add(new TrapMaster());
        roles.add(new Poisoner());

        roles.add(new Detective());
        roles.add(new Doctor());
        roles.add(new Vigilante());
        roles.add(new Nun());
        roles.add(new Bodyguard());
        roles.add(new Veteran());
        roles.add(new Judge());
        roles.add(new Survivalist());

        roles.add(new Jester());
        roles.add(new Accuser());
        roles.add(new Witch());
        roles.add(new SerialKiller());
        roles.add(new Arsonist());
        roles.add(new Yandere());
        roles.add(new Amnesiac());

        return roles;
    }

    public static List<RoleHistory> initRoleHistory() {
        List<RoleHistory> history = new ArrayList<>();
        List<Role> roles = Helper.initRoles();
        ScrambleId scramble = new ScrambleId(roles.size());
        for (int i = 0; i < roles.size(); i++) {
            RoleHistory rh = new RoleHistory();

            rh.setRole(roles.get(i));
            rh.setId(scramble.get(i));

            history.add(rh);
        }

        return history;
    }
}
