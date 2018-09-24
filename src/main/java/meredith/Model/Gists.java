package meredith.Model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gists {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private Owner owner;
    private List<File> lstFiles = new ArrayList<File>();
    private String description;
    private Date created_at;
    private Date updated_at;


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<File> getLstFiles() {
        return lstFiles;
    }

    public void setLstFiles(List<File> lstFiles) {
        this.lstFiles = lstFiles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Gists)){
            return false;
        }

        Gists gists = (Gists) o;
        return new EqualsBuilder().append(id, gists.id)
                .append(owner, gists.owner)
                .append(lstFiles, gists.lstFiles)
                .append(description, gists.description)
                .append(created_at, gists.created_at)
                .append(updated_at, gists.updated_at)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(owner)
                .append(lstFiles)
                .append(description)
                .append(created_at)
                .append(updated_at)
                .toHashCode();
    }

}
