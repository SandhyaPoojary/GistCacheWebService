# GistCacheWebService

Below is the url to execute using Swagger :

http://localhost:8080/swagger-ui.html#/gist-controller/


/getSingleGist -retrieve a single gist of the ID passed. First the gist is checked if it exists in the cache, if found it is returned 
from the cache, if not found api call is made to retrieve from the https://api.github.com/ and later added to the cache;

/updateCache - retrieve gist of particular ID from the github . Retrieve gist of the same ID from the cache. Compared both the gist objects
using org.apache.commons. If it is not equal , removed that gist from cache and added the one retrived from the github.

/deleteFromCache - deletes the gist from the cache;

/getAllGists - retrieves all the gists from the cache;


Note : Used HashMap to implement caching, would have used ehcache if the project required;

