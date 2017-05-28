package co.edu.umariana.luiseduardo.pokeap.pokeApi;

import co.edu.umariana.luiseduardo.pokeap.models.Pokemon;
import co.edu.umariana.luiseduardo.pokeap.models.PokemonRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by luiseduardo on 22/05/17.
 */

public interface PokeApService
{
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<Pokemon> obtenerDatosPokemon(@Path("id") int id);
    @GET("pokemon/{id}")
    Call<Pokemon> obtenerImagenPokemon(@Path("id") int id);
}
