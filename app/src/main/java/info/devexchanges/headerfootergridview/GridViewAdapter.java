package info.devexchanges.headerfootergridview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class GridViewAdapter extends ArrayAdapter<Integer> {

    private Activity activity;
    private Integer[] drawablesResource;

    public GridViewAdapter(Activity context, int resource, Integer[] objects) {
        super(context, resource, objects);
        this.activity = context;
        this.drawablesResource = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_grid, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        //set drawable to imageview
        holder.imageView.setImageResource(getItem(position));

        return convertView;
    }

    private class ViewHolder {

        private ImageView imageView;

        public ViewHolder(View v) {
            imageView = (ImageView) v.findViewById(R.id.img);
        }
    }
}
