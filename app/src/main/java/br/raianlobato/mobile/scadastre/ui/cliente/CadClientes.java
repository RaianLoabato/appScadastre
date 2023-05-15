package br.raianlobato.mobile.scadastre.ui.cliente;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import br.raianlobato.mobile.scadastre.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadClientes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadClientes extends Fragment {

    //atributos
    private EditText txnome;
    private EditText txtelefone;
    private EditText txemail;
    private EditText txidentidade;
    private EditText txendereco;
    private EditText txcomplemento;
    private EditText txcep;
    private EditText txcpf;
    private EditText txsenha;
    private EditText txrepsenha;
    private Spinner sppais;
    private Button btsalvar;
    private View root;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadClientes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadClientes.
     */
    // TODO: Rename and change types and number of parameters
    public static CadClientes newInstance(String param1, String param2) {
        CadClientes fragment = new CadClientes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar()
                .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        this.root = inflater.inflate(R.layout.fragment_cad_clientes, container, false);
        this.txnome = (EditText) root.findViewById(R.id.txnome);
        this.txtelefone = (EditText) root.findViewById(R.id.txtelefone);
        this.txemail = (EditText) root.findViewById(R.id.txemail);
        this.txidentidade = (EditText) root.findViewById(R.id.txidentidade);
        this.txendereco = (EditText) root.findViewById(R.id.txendereco);
        this.txcomplemento = (EditText) root.findViewById(R.id.txcomplemento);
        this.txcep = (EditText) root.findViewById(R.id.txcep);
        this.txcpf = (EditText) root.findViewById(R.id.txcpf);
        this.txsenha = (EditText) root.findViewById(R.id.txsenha);
        this.sppais = (Spinner) root.findViewById(R.id.sppais);
        this.btsalvar = (Button) root.findViewById(R.id.btsalvar);


        return root;
    }
}