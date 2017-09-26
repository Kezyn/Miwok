package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static com.example.android.miwok.R.id.img;

/**
 * Created by Marc on 21.08.2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context c, List<Word> words, int colorResourceId) {
        // Can pass 0 as layout id, since we inflate from the layout manually in getView() method.
        super(c, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            // Instantiates a layout XML file into its corresponding View objects
            // Creates an actual 'View' object from the XML file
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        // The word object to be converted to a view next.
        Word currentWord = getItem(position);

        TextView defaultTextView =(TextView) convertView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTextView = (TextView) convertView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) convertView.findViewById(img);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());

            // Make sure View is visible (might be reused and previously hidden)
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        LinearLayout textContainer = (LinearLayout) convertView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        return convertView;
    }
}
