package meredith.Services;

import meredith.Model.Gists;

import java.util.List;

public interface CacheService {

    public Gists getGistFromCache(String id);
    public void addGistToCache(Gists gist);
    public boolean deleteGistFromCache(String id);
    public boolean updateGitCache(Gists gist);
    public List<Gists> getAllGistsFromCache();
}
