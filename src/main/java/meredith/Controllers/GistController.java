package meredith.Controllers;


import meredith.Model.Gists;
import meredith.Services.CacheService;
import meredith.Services.CacheServiceImpl;
import meredith.Services.GistService;
import meredith.Services.GistServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class GistController {

    private GistService gistService;
    private CacheService cacheService;

    public GistController(){
        gistService = new GistServiceImpl();
        cacheService = new CacheServiceImpl();
    }


    @GetMapping("/getSingleGist")
    public Gists getSingleGist(@RequestParam("id") String id){
        Gists gists = cacheService.getGistFromCache(id);
        if(gists == null) {
            gists = gistService.getGists(id);
            cacheService.addGistToCache(gists);
        }
        return gists;
    }

    @GetMapping("/getAllGists")
    public List<Gists> getAllGists(){
        return cacheService.getAllGistsFromCache();

    }

    @GetMapping("/deleteFromCache")
    public boolean deleteFromCache(String gitGistId){
        return cacheService.deleteGistFromCache(gitGistId);
    }


    @GetMapping("/updateCache")
    public boolean updateCache(String gitGistId){
        Gists remoteGist = gistService.getGists(gitGistId);
        return cacheService.updateGitCache(remoteGist);
    }

    }
