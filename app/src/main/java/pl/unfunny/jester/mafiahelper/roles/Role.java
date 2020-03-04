package pl.unfunny.jester.mafiahelper.roles;

import java.io.Serializable;

abstract public class Role implements Serializable {

    private int roleNameId;
    private int shortNameId;
    private int roleDecriptionId;

    private Faction faction;
    private int turnOrder;

    private ActionNight night;
    private ActionDay day;

    private Attack attack;
    private Defence defence;

    private int iconResId;


    public Role() {}

    public Role(int roleNameId, int shortNameId, int roleDescriptionId, Faction faction, int turnOrder, ActionNight night, ActionDay day, Attack attack, Defence defence, int iconResId) {
        this.roleNameId = roleNameId;
        this.shortNameId = shortNameId;
        this.roleDecriptionId = roleDescriptionId;
        this.faction = faction;
        this.turnOrder = turnOrder;
        this.night = night;
        this.day = day;
        this.attack = attack;
        this.defence = defence;
        this.iconResId = iconResId;
    }

    public Role(Faction faction) {
        this.faction = faction;
    }

    public int getRoleName() {
        return roleNameId;
    }

    public int getShortName() {
        return shortNameId;
    }

    public int getRoleDecription() {
        return roleDecriptionId;
    }

    abstract public int getRoleFlavour();

    public Faction getFaction() {
        return faction;
    }

    public int getTurnOrder() {
        return 100*faction.factionOrder() + turnOrder;
    }

    public ActionNight getNight() {
        return night;
    }

    public ActionDay getDay() {
        return day;
    }

    public Attack getAttack() {
        return attack;
    }

    public Defence getDefence() {
        return defence;
    }

    public int getIconResId() {
        return iconResId;
    }
}
