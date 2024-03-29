package eu.ase.ro.s5_fragmente.fragmente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eu.ase.ro.s5_fragmente.Constante;
import eu.ase.ro.s5_fragmente.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private View view;
    private TextView tvStringReceive, tvIntegerReceive;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvStringReceive = view.findViewById(R.id.profileFragment_tv_stringReceive);
        tvIntegerReceive = view.findViewById(R.id.profileFragment_tv_integerReceive);

        receiveStringInteger();

        return view;
    }

    private void receiveStringInteger(){
        //PAS 1: Verificam daca avem ceva de primit
        if(getArguments() != null) {

            //PAS 2: Preluam Bundle
            Bundle bundle = getArguments();

            //PAS 3: Preluam informatiile din Bundle
            String stringReceive = bundle.getString(Constante.SEND_MAIN_PROFILE_STRING);
            int integerReceive = bundle.getInt(Constante.SEND_MAIN_PROFILE_INTEGER);

            //PAS 4: Setam informatiile in TextView-uri
            tvStringReceive.setText(stringReceive);
            tvIntegerReceive.setText(String.valueOf(integerReceive));
        }
    }
}