package meredith.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class File {

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("filename")
    private String filename;
    private String size;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof File)){
            return false;
        }

        File file = (File) o;
        return new EqualsBuilder().append(filename, file.filename)
                .append(size, file.size)
                .append(type, file.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(filename)
                .append(size)
                .append(type)
                .toHashCode();
    }

}
