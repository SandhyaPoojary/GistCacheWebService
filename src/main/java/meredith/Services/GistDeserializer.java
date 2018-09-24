package meredith.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import meredith.Model.File;
import meredith.Model.Gists;
import meredith.Model.Owner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GistDeserializer {

    public Gists deserialize(String response){
        Gists gitGist = new Gists();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(response);
            deserializeGistMetaData(gitGist, root);
            gitGist.setLstFiles(deserializeFiles(root));
            gitGist.setOwner(deserializeOwner(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gitGist;
    }

    private void deserializeGistMetaData(Gists gitGist, JsonNode root){
        gitGist.setDescription(root.path("description").asText());
        gitGist.setId(root.path("id").asText());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try{
            gitGist.setCreated_at(formatter.parse(root.path("created_at").asText()));
            gitGist.setUpdated_at(formatter.parse(root.path("updated_at").asText()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private Owner deserializeOwner(JsonNode root){
        Owner owner = new Owner();
        JsonNode ownerNode = root.path("owner");
        owner.setLogin(ownerNode.path("login").asText());
        owner.setId(ownerNode.path("id").asText());
        return owner;
    }

    private List<File> deserializeFiles(JsonNode root){
        List<File> files = new ArrayList<>();
        JsonNode fileNodes = root.path("files");
        for (JsonNode fileNode : fileNodes){
            File file = new File();
            file.setFilename(fileNode.path("filename").asText());
            file.setType(fileNode.path("type").asText());
            file.setSize(fileNode.path("size").asText());
            files.add(file);
        }
        return files;
    }
}
