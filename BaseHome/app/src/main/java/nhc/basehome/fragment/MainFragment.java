package nhc.basehome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nhc.basehome.R;

/**
 * Created by NHC on 1/12/2015.
 */
public class MainFragment extends Fragment {
    private View rootView;
    private static MainFragment mainFragment;

    public static MainFragment getInstance() {
        /*if (mainFragment == null) {
            mainFragment = new MainFragment();
        }
        return mainFragment;*/
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, null, false);
        return rootView;
    }
}
