package co.edu.umariana.luiseduardo.pokeap;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Attributes;

import co.edu.umariana.luiseduardo.pokeap.models.Ability;
import co.edu.umariana.luiseduardo.pokeap.models.Ability_;
import co.edu.umariana.luiseduardo.pokeap.models.Dato;
import co.edu.umariana.luiseduardo.pokeap.models.Pokemon;
import co.edu.umariana.luiseduardo.pokeap.pokeApi.PokeApService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luiseduardo on 22/05/17.
 */

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>
{
    private static final String TAG="POKEDEX";
    private ArrayList<Pokemon> dataset;
    private Context context;
    MediaPlayer mp;
    private ImageView fotoImageView;

    public ListaPokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());

        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);


        holder.fotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent i = new Intent(context,TarjetaActivity.class);
                i.putExtra("id",p.getNumber());
                //i.putExtra("id",p.getNumber());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView nombreTextView;
        public ViewHolder(final View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);

            }
        }

   /* public void onAlertDialog(Pokemon pokemon)
    {
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
        }*/

        /*AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("** Información básica del pokemón **");
        alertDialog.setMessage("° Nombre: " + pokemon.getName() +
                "\n" + "° Código: " + pokemon.getId() +
                "\n" + "° Peso: " + pokemon.getWeight() + " kg" +
                "\n" + "° Altura: " + pokemon.getHeight() + " cm" +
                "\n" + "° Tipo: " + pokemon.getTypes().get(0).getType().getName() +
                "\n" + "° Habilidad: " + ability +
                "\n" + "° Habilidad 2: "+abi2+
                "\n" + "° Habilidad 3: "+abi+
                "\n" + "° Experiencia: " + pokemon.getBase_experience() + " pts");
        alertDialog.show();*/
    }