package co.edu.umariana.luiseduardo.pokeap;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by luiseduardo on 22/05/17.
 */

public class Dialogo extends DialogFragment
{
    public Dialog onCreateDialog(Bundle SaveInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Caracteristicas")
                .setMessage("Soy un dialogo")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });

        return builder.create();
    }
}
