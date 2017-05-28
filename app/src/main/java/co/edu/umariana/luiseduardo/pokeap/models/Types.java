package co.edu.umariana.luiseduardo.pokeap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by luiseduardo on 24/05/17.
 */

public class Types
{
    private String slot;
    private Dato type;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Dato getType() {
        return type;
    }

    public void setType(Dato type) {
        this.type = type;
    }
}
