package view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tivra.mh.mhtracker_proto.R;

public class FirstFragment extends Fragment {
TextView   textView;
    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        textView= (TextView)view.findViewById(R.id.text_view);
        Bundle bundle = getArguments();
        String msg= Integer.toString(bundle.getInt("count"));
        textView.setText("This is the "+ msg + "Swipe Page view...");
        return view;
//        return inflater.inflate(R.layout.fragment_first, container, false);
    }




}
