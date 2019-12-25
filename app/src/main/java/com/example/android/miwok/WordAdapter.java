package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    int mColorId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorId) {
        super(context, 0, words);
        mColorId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        listItemView.setBackgroundColor(mColorId);
        final Word currentWord = getItem(position);
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_translation);
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_translation);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }
        else {
            image.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
