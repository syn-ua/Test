package pro.i_it.resume.ui.master;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.i_it.resume.R;
import pro.i_it.resume.ui.master.interfaces.IMore;
import pro.i_it.resume.ui.master.model.RepositoryViewModel;

/**
 * Created by syn on 13.07.17.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
    private ArrayList<RepositoryViewModel> data;
    private IMore more;

    public RepositoryAdapter() {
        data = new ArrayList<>();
    }

    public void update(ArrayList<RepositoryViewModel> repositoryViewModels, boolean isFullUpDate) {
        int count = this.data.size();
        this.data.clear();
        if (repositoryViewModels != null) {
            this.data.addAll(repositoryViewModels);
        }
        if (isFullUpDate) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeChanged(count, this.data.size());
        }

    }

    public void setMore(IMore more) {
        this.more = more;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_repository, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(getItemByPosition(position).getFullName());
        holder.avatar.setImageURI(getItemByPosition(position).getOwner().getAvatarUrl());
        if (position == data.size() - 1 && more != null) {
            more.needMoreItem();
        }
    }

    private RepositoryViewModel getItemByPosition(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cell_repository_name)
        protected TextView name;
        @BindView(R.id.cell_repository_image)
        protected SimpleDraweeView avatar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
