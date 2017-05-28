package co.edu.umariana.luiseduardo.pokeap.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luiseduardo on 22/05/17.
 */

public class Pokemon{
   /* private ArrayList<Types> types;
    private String url;
    public void setNumber(Integer number) {this.number = number;}
    public int getNumber()
    {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {this.number = number;}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("number")

    @Expose
    private Integer number;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("forms")
    @Expose
    private List<Object> locationAreaEncounters = null;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Object> getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(List<Object> locationAreaEncounters) {this.locationAreaEncounters = locationAreaEncounters;}

    public ArrayList<Types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }*/
    private Integer id;
    private String name;
    private String weight;
    private String height;
    private String url;
    private String base_experience;

    public String getBase_experience() {return base_experience;}

    public void setBase_experience(String base_experience) {this.base_experience = base_experience;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public Integer getNumber() {

            String[] urlPartes = url.split("/");
            return Integer.parseInt(urlPartes[urlPartes.length - 1]);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    private Integer number;

    private ArrayList<Ability> abilities;
    public ArrayList<Ability> getAbilities() {return abilities;}

    public void setAbilities(ArrayList<Ability> abilities) {this.abilities = abilities;}

    private ArrayList<Types> types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }




}
