package com.example.btth03.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btth03.R;
import com.example.btth03.Utils.utils;
import com.example.btth03.data.model.Student;

import java.util.List;

public class StudentAdapter extends
        RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private final List<Student> students;
    private final Context context;
    private final OnItemClickListener listener;


    public StudentAdapter(Context context, List<Student> students,
                          OnItemClickListener listener) {
        this.students = students;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        View adapterLayout = LayoutInflater.from(context)
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(adapterLayout);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.textId.setText(student.getStudentId());
        holder.textGpa.setText("" + student.getGpa());
        holder.textFullName.setText(student.getFullName());
        holder.imageAvartar.setImageDrawable(
                utils.getDrawable(context, student.getGender()));
        holder.bind(student, listener);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setStudents(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvartar;
        TextView textId;
        TextView textFullName;
        TextView textGpa;
        @NonNull
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageAvartar = itemView.findViewById(R.id.img_ava);
            textId = itemView.findViewById(R.id.txt_id);
            textFullName = itemView.findViewById(R.id.txt_name);
            textGpa = itemView.findViewById(R.id.txt_gpa);
        }

        public void bind(Student student, OnItemClickListener listener) {
            itemView.setOnClickListener(l -> listener.onItemClick(student));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Student student);
    }
}
