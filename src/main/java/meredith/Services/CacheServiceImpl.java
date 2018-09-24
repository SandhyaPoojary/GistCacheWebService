package meredith.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import meredith.Model.Gists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CacheServiceImpl implements CacheService {
    private static HashMap<String, Gists> gistCache = new HashMap<String, Gists>();

    @Override
    public Gists getGistFromCache(String id) {
        return gistCache.containsKey(id) ? gistCache.get(id) : null;
    }

    @Override
    public void addGistToCache(Gists gist) {
        gistCache.put(gist.getId(), gist);
    }

    @Override
    public boolean deleteGistFromCache(String id) {
        if (gistCache.containsKey(id)) {
            gistCache.remove(id);
            return true;
        }
        return false;
    }

    public boolean updateGitCache(Gists remoteGitGist) {
        if (gistCache.containsKey(remoteGitGist.getId())) {
            Gists localGist = gistCache.get(remoteGitGist.getId());

            if (!remoteGitGist.equals(localGist)) {
                gistCache.remove(remoteGitGist.getId());
                gistCache.put(remoteGitGist.getId(), remoteGitGist);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<Gists> getAllGistsFromCache() {
        return new ArrayList<Gists>(gistCache.values());
    }

}
