package pl.unfunny.jester.mafiahelper.roles;

public enum Faction {
    MAFIA("Mafia", 0),
    TOWN("Miasto", 8),
    NEUTRAL("Neutralni", 9);

    private final int factionOrder;
    private final String factionName;

    Faction(String factionName, int factionOrder) {
        this.factionName = factionName;
        this.factionOrder = factionOrder;
    }

    public int factionOrder() {
        return factionOrder;
    }

    public String factionName() {
        return factionName;
    }
}
