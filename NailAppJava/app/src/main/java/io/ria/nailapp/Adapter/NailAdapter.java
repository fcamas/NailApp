package io.ria.nailapp.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.ria.nailapp.MainActivity;
import io.ria.nailapp.Model.NailModel;
import io.ria.nailapp.R;
import io.ria.nailapp.Utils.NailDBHelper;
public class NailAdapter extends RecyclerView.Adapter<NailAdapter.MyViewHolder> {

    private List<NailModel> mList;
    private MainActivity mActivity;
    private NailDBHelper nailHelper;

    public NailAdapter(NailDBHelper nailHelper, MainActivity mActivity){
        this.mActivity = mActivity;
        this.nailHelper = nailHelper;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final NailModel item = mList.get(position);

        holder.mFullName.setText(item.getFullName());
        holder.mEmail.setText(item.getEmail());
        holder.mPhone.setText(item.getPhone());
        holder.mTime.setText(item.getTime());
        holder.mService.setText(item.getService());
        holder.mCheckBox.setText(item.getTask());
        holder.mCheckBox.setChecked(toBoolean(item.getStatus()));
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    nailHelper.updateStatus(item.getId() , 1);
                }else
                    nailHelper.updateStatus(item.getId() , 0);
            }
        });
    }

    public boolean toBoolean(int num){
        return num!=0;
    }

    public Context getContext(){
        return mActivity;
    }

    public void setTasks(List<NailModel> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void deletTask(int position){
        NailModel item = mList.get(position);
        nailHelper.deleteTask(item.getId());
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void editItem(int position){
        NailModel item = mList.get(position);

        Bundle bundle = new Bundle();
        bundle.putInt("id" , item.getId());
        bundle.putString("task" , item.getTask());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CheckBox mCheckBox;
        TextView mFullName;
        TextView mEmail;
        TextView mPhone;
        TextView mTime;
        TextView mService;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCheckBox = itemView.findViewById(R.id.cell_checkbox);
            mFullName = itemView.findViewById(R.id.cell_fullname);
            mEmail = itemView.findViewById(R.id.cell_email);
            mPhone = itemView.findViewById(R.id.cell_phone);
            mTime = itemView.findViewById(R.id.cell_time);
            mService = itemView.findViewById(R.id.cell_service);
        }
    }
}