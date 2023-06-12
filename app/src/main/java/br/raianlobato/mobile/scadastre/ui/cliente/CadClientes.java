/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby,
 C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import br.raianlobato.mobile.scadastre.R;
import br.raianlobato.mobile.scadastre.model.Cliente;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadClientes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadClientes extends Fragment implements View.OnClickListener , Response.ErrorListener,
        Response.Listener{

    //atributos
    private EditText txnome;
    private EditText txtelefone;
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

    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;

    //



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

        this.txnome = (EditText) root.findViewById(R.id.txnm);
        this.txtelefone = (EditText) root.findViewById(R.id.txtelefone);
        this.txidentidade = (EditText) root.findViewById(R.id.txidentidade);
        this.txendereco = (EditText) root.findViewById(R.id.txendereco);
        this.txcomplemento = (EditText) root.findViewById(R.id.txcomplemento);
        this.txcep = (EditText) root.findViewById(R.id.txcep);
        this.txcpf = (EditText) root.findViewById(R.id.txcpf);
        this.txsenha = (EditText) root.findViewById(R.id.txsenha);
        this.sppais = (Spinner) root.findViewById(R.id.sppais);
        this.btsalvar = (Button) root.findViewById(R.id.btsalvar);
        //definindo o listener do botão5634477
        this.btsalvar.setOnClickListener(this);

        //instanciando a fila de requests - caso o objeto seja o root
        this.requestQueue = Volley.newRequestQueue(root.getContext());

        //inicializando a fila de requests do SO
        this.requestQueue.start();


        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //verificando se é o botão salvar case R.id.btSalvar:
            case R.id.btsalvar:

                //instanciando class de negócio

                Cliente c = new Cliente();


                c.setNomeCompleto(this.txnome.getText().toString());
                c.setNumerodeCelular(this.txtelefone.getText().toString());
                c.setNumerodeIdentidade(this.txidentidade.getText().toString());
                c.setEndereco(this.txendereco.getText().toString());
                c.setComplemento(this.txcomplemento.getText().toString());
                c.setCEP(this.txcep.getText().toString());
                c.setCPF(this.txcpf.getText().toString());
                c.setSenha(this.txsenha.getText().toString());
                //Spiner
                c.setPais(String.valueOf(this.sppais.getSelectedItemPosition()));
/*
                Context context =  view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText (context, text, duration); toast.show();
*/
                //request para servidor REST
                jsonObjectReq = new JsonObjectRequest( Request.Method.POST,
                        "http://10.0.2.2/cadpessoa.php",
                        c.toJsonObject(), this, this);
                requestQueue.add(jsonObjectReq);
                break;
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(Object response) {
        String resposta = response.toString(); try {
            Snackbar mensagem = null;
            if (resposta.equals("500")) {
                mensagem = Snackbar.make(root, "Erro! = " + resposta, Snackbar.LENGTH_LONG);
                mensagem.show();
            } else {
                //sucesso //limpar campos da tela
                this.txnome.setText("");
                this.txtelefone.setText("");
                this.txidentidade.setText("");
                this.txendereco.setText("");
                this.txcomplemento.setText("");
                this.txcep.setText("");
                this.txcpf.setText("");
                this.txsenha.setText("");
                //mensagem de sucesso Snackbar mensagem =
                Snackbar.make(root, "Sucesso! = " + resposta, Snackbar.LENGTH_LONG);
                mensagem.show();
            }
        } catch (Exception e) {  e.printStackTrace(); }



    }
}


