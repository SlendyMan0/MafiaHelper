package pl.unfunny.jester.mafiahelper.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.unfunny.jester.mafiahelper.R;
import pl.unfunny.jester.mafiahelper.listeners.RoleCounterListener;
import pl.unfunny.jester.mafiahelper.roles.Role;

public class RoleChooserAdapter extends RecyclerView.Adapter<RoleChooserAdapter.RoleChooserAdapterViewHolder> {

    private Context context;

    private List<Role> roles;
    private List<Boolean> rolesSelected;


    class RoleChooserAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView card_role;
        RelativeLayout relative_role;
        ImageView image_role;
        TextView text_role;

        RoleChooserAdapterViewHolder(@NonNull View view) {
            super(view);

            view.setOnClickListener(this);

            card_role = view.findViewById(R.id.card_role);
            relative_role = view.findViewById(R.id.relative_role);
            image_role = view.findViewById(R.id.image_role);
            text_role = view.findViewById(R.id.text_role);
        }

        void setDataOnView() {
            if (rolesSelected.get(getAdapterPosition())) {
                card_role.setCardBackgroundColor(context.getColor(R.color.grey_border));
                relative_role.setBackgroundResource(R.color.grey_selected);
                text_role.setTextColor(context.getColor(R.color.text_normal));
            } else {
                card_role.setCardBackgroundColor(context.getColor(R.color.invisible));
                relative_role.setBackgroundResource(R.color.invisible);
                text_role.setTextColor(context.getColor(R.color.text_fading));
            }

            image_role.setImageResource(roles.get(getAdapterPosition()).getIconResId());

            text_role.setText(context.getResources().getString(roles.get(getAdapterPosition()).getRoleName()));
        }

        @Override
        public void onClick(View v) {
            rolesSelected.set(getAdapterPosition(), !rolesSelected.get(getAdapterPosition()));

            if (context instanceof RoleCounterListener) {
                ((RoleCounterListener) context).onRoleTap(rolesSelected.get(getAdapterPosition()), roles.get(getAdapterPosition()).getFaction());
            }

            notifyItemChanged(getAdapterPosition());
        }
    }

    public RoleChooserAdapter(Context context, List<Role> roles) {
        this.context = context;
        this.roles = roles;
        this.rolesSelected = new ArrayList<>(Collections.nCopies(roles.size(), false));
    }

    public List<Role> getSelectedRoles() {
        List<Role> selectedRoles = new ArrayList<>();

        for (int i = 0; i < roles.size(); i++) {
            if (rolesSelected.get(i)) {
                selectedRoles.add(roles.get(i));
            }
        }

        return selectedRoles;
    }

    @NonNull
    @Override
    public RoleChooserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_roles, viewGroup, false);

        return new RoleChooserAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoleChooserAdapterViewHolder viewHolder, int i) {
        viewHolder.setDataOnView();
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }
}
