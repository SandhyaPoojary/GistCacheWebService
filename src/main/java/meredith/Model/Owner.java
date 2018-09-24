package meredith.Model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Owner {

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String login;
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Owner)){
            return false;
        }

        Owner owner = (Owner) o;
        return new EqualsBuilder().append(id, owner.id)
                .append(login, owner.login).isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(login)
                .toHashCode();
    }

}
