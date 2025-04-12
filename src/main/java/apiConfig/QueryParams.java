package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {
    //Sample Query Params
    public Map<String, String> defaultQueryParams(String id){
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("userId", id);

        return queryParam;

    }
}
