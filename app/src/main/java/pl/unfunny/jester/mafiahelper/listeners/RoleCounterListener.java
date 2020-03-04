package pl.unfunny.jester.mafiahelper.listeners;

import android.support.annotation.UiThread;

import pl.unfunny.jester.mafiahelper.roles.Faction;

public interface RoleCounterListener {

    @UiThread
    void onRoleTap(boolean selected, Faction faction);
}
