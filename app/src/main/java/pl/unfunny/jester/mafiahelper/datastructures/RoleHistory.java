package pl.unfunny.jester.mafiahelper.datastructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.unfunny.jester.mafiahelper.roles.Role;

public class RoleHistory implements Serializable {

    private Role role;
    private String id;
    private List<String> action = new ArrayList<>();

    private boolean alive = true;

    public Role getRole() {
        return role;
    }

    public int getRoleImage() {
        return role.getIconResId();
    }

    public int getRoleName() {
        return role.getRoleName();
    }

    public int getRoleShort() {
        return role.getShortName();
    }

    public int getRoleDesc() {
        return role.getRoleDecription();
    }

    public int getRoleFlavour() {
        return role.getRoleFlavour();
    }

    public String getId() {
        return id;
    }

    public String getAction(int i) {
        return action.get(i);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAction(String s) {
        this.action.add(s);
    }

    public void kill() {
        this.alive = false;
    }
}
