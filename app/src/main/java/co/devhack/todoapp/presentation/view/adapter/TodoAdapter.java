package co.devhack.todoapp.presentation.view.adapter;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.devhack.todoapp.R;
import co.devhack.todoapp.domain.model.Todo;

/**
 * Created by Rodolhan on 9/12/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> dataSet;
    private OnTodoFinishChange onTodoFinishChange;
    public TodoAdapter(List<Todo> dataSet) {
        this.dataSet = dataSet;
        this.onTodoFinishChange = onTodoFinishChange;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = dataSet.get(position);
        try {
            holder.cbFinished.setChecked(todo.getFinished());
            holder.cbFinished.setText(todo.getDescription());
            //TODO holder.ivPhoto.
            //TODO FORMATEAR FECHA USANDO java.text.SimpleDateFormat
            holder.tvFinishDate.setText(todo.getFinishDate().toString());
            if (todo.getFinished()) {
                holder.tvFinishDate.setPaintFlags(holder.tvFinishDate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                holder.tvFinishDate.setPaintFlags(holder.tvFinishDate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface OnTodoFinishChange {
        void onTodoFinishChange(int position, boolean finished);
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        public CheckBox cbFinished;
        public ImageView ivPhoto;
        public TextView tvFinishDate;

        public TodoViewHolder(View itemView) {
            super(itemView);

            cbFinished = itemView.findViewById(R.id.cbFinished);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvFinishDate = itemView.findViewById(R.id.tvFinishDate);
            if (onTodoFinishChange != null) {
                cbFinished.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                        onTodoFinishChange.onTodoFinishChange(position, cbFinished.isChecked());
                    }
                });
            }
        }
    }

}
