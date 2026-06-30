package com.example.mybookcatal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(@NonNull Context context, @NonNull List<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }

        ImageView imageCover = convertView.findViewById(R.id.imageCover);
        TextView textTitle = convertView.findViewById(R.id.textTitle);
        TextView textAuthor = convertView.findViewById(R.id.textAuthor);

        if (book != null) {
            textTitle.setText(book.getTitle());
            textAuthor.setText("by " + book.getAuthor());
            imageCover.setImageResource(book.getImageResId());
        }

        return convertView;
    }
}
