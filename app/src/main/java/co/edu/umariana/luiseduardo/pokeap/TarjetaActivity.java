package co.edu.umariana.luiseduardo.pokeap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.edu.umariana.luiseduardo.pokeap.models.Pokemon;
import co.edu.umariana.luiseduardo.pokeap.pokeApi.PokeApService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TarjetaActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private TextView tv_nombre, tv_codigo, tv_peso, tv_altura, tv_tipo, tv_habilidad, tv_habilidad1, tv_habilidad2, tv_experiencia;
    private static final String TAG = "POKEDEX";
    private Context context;
    private ArrayList<Pokemon> dataset;
    private ImageView fotoPokeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);
        tv_nombre = (TextView) findViewById(R.id.nombrePokemon);
        tv_codigo = (TextView) findViewById(R.id.txt_codigo);
        tv_peso = (TextView) findViewById(R.id.txt_peso);
        tv_altura = (TextView) findViewById(R.id.txt_altura);
        tv_tipo = (TextView) findViewById(R.id.txt_tipo);
        tv_habilidad = (TextView) findViewById(R.id.txt_habilidad);
        tv_habilidad1 = (TextView) findViewById(R.id.txt_habilidad1);
        tv_habilidad2 = (TextView) findViewById(R.id.txt_habilidad2);
        tv_experiencia = (TextView) findViewById(R.id.txt_experiencia);
        fotoPokeImageView = (ImageView) findViewById(R.id.fotoPokeImageView);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            int idPokemon = (int) bundle.get("id");
            //int imagePokemon = (int) bundle.get("id");
            String id = idPokemon + "";
            obtenerDatosPokemon(idPokemon);
            //obetnerImagen(imagePokemon);

        }
    }

    public void TargetaActivity(Context context) {
      this.context = context;
      dataset = new ArrayList<>();
    }

    private void obtenerDatosPokemon(final int id) {

        PokeApService service = retrofit.create(PokeApService.class);
        Call<Pokemon> pokemonRespuestaCall = service.obtenerDatosPokemon(id);

        pokemonRespuestaCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body();
                    tv_nombre.setText(pokemon.getName());
                    tv_codigo.setText(pokemon.getId().toString());
                    tv_peso.setText(pokemon.getWeight() + " kg");
                    tv_altura.setText(pokemon.getHeight() + " cm");
                    tv_tipo.setText(pokemon.getTypes().get(0).getType().getName());
                    String ability="";
                    String abi="";
                    String abi2="";
                    int j= 0;
                    int l=0;
                    for(int i= 0;i<pokemon.getAbilities().size();i++) {
                        ability = pokemon.getAbilities().get(i).getAbility().getName();
                        if(i>0) {
                            abi = pokemon.getAbilities().get(j).getAbility().getName();
                            j = 0;
                            if(i!=1) {
                                l = j + 1;
                                abi2 = pokemon.getAbilities().get(l).getAbility().getName();
                            }
                        }
                    }
                    tv_habilidad.setText("» "+ability);
                    tv_habilidad1.setText("» "+abi);
                    tv_habilidad2.setText("» "+abi2);
                    tv_experiencia.setText(pokemon.getBase_experience() + " pts");

                    Glide.with(getApplicationContext())
                            .load("http://pokeapi.co/media/sprites/pokemon/" + pokemon.getId() + ".png")
                            .centerCrop()
                            .crossFade()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(fotoPokeImageView);
                }
                else
                 {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
    public void volver(View view) {finish();}

}
