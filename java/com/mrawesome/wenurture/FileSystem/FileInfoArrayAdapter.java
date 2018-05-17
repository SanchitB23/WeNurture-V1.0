package com.mrawesome.wenurture.FileSystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrawesome.wenurture.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanch on 07-04-2018 for WeNurture-SQLiteConnectivity.
 */
public class FileInfoArrayAdapter extends ArrayAdapter<FileInfoArrayList> {

    final String LOG_TAG = "FileInfoArrayAdapter";
    public FileInfoArrayAdapter(@NonNull Context context, @NonNull List<FileInfoArrayList> objects) {
        super(context,0,objects);
    }

    Map fileTypeMap = new HashMap();
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        fileTypeMap.put(0,"Folder");
        fileTypeMap.put(1,"Pdf");
        fileTypeMap.put(2,"Doc");
        int pdfIcon = R.drawable.ic_pdf;
        int docIcon = R.drawable.ic_doc;
        int folderIcon = R.drawable.icon_folder;

        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.file_list_item,parent,false);
        FileInfoArrayList currentFile = getItem(position);

//        View textContainer = (View) listItemView.findViewById(R.id.layout_file_text);

        TextView fileNameTextView = (TextView) listItemView.findViewById(R.id.file_name_text_view);
        fileNameTextView.setText(currentFile.getFileName());

        TextView fileTypeTextView = (TextView) listItemView.findViewById(R.id.file_type_text_view);

        fileTypeTextView.setText(((String) fileTypeMap.get(currentFile.getFileType())));
        Log.i(LOG_TAG,"Map Working");

        ImageView fileIcon = (ImageView) listItemView.findViewById(R.id.file_type_icon);

        switch (currentFile.getFileType()){
            case 0:
                fileIcon.setImageResource(folderIcon);
                break;
            case 1:
                fileIcon.setImageResource(pdfIcon);
                break;
            case 2:
                fileIcon.setImageResource(docIcon);
                break;
        }

        return listItemView;
    }
}

