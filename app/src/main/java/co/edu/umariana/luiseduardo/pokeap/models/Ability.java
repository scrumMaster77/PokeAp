package co.edu.umariana.luiseduardo.pokeap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by luiseduardo on 24/05/17.
 */

public class Ability
{
        @SerializedName("is_hidden")
        @Expose
        private Boolean isHidden;
        @SerializedName("slot")
        @Expose
        private Integer slot;
        @SerializedName("ability")
        @Expose
        private Ability_ ability;

        public Boolean getIsHidden() {
            return isHidden;
        }

        public void setIsHidden(Boolean isHidden) {
            this.isHidden = isHidden;
        }

        public Integer getSlot() {
            return slot;
        }

        public void setSlot(Integer slot) {
            this.slot = slot;
        }

        public Ability_ getAbility() {
            return ability;
        }

        public void setAbility(Ability_ ability) {
            this.ability = ability;
        }

    }

