package pro.i_it.resume.remote.github.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by syn on 13.07.17.
 */

public class RepositorySearchNetModel {
    private Long id;
    @SerializedName("full_name")
    private String fullName;
    private String description;

    private Owner owner;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static class Owner {
        private Long id;
        private String login;
        @SerializedName("avatar_url")
        private String avatarUrl;

        public Long getId() {
            return id;
        }


        public void setId(Long id) {
            this.id = id;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
