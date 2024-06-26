import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTask{
    public static void main (String path1, String path2, String path3){
        JSONParser parser = new JSONParser();
        List<Tests> testlist = new ArrayList<>();
        Map<String, String> result = new HashMap<>();
        File res= new File(path3);
        ObjectMapper objmap = new ObjectMapper();
        try {
            JSONObject tests = (JSONObject) parser.parse(new FileReader(path1));
            JSONObject values = (JSONObject) parser.parse(new FileReader(path2));
            JSONArray ja1 = (JSONArray) values.get("values");
            JSONArray ja2 = (JSONArray) tests.get("tests");
            parsetest(ja2, testlist);
            parsevalues(ja1, result);
            for (Tests t1: testlist){
                if (result.containsKey(t1.getId())){
                    t1.setValue(result.get(t1.getId()));
                }
            }
            objmap.writeValue(res,testlist);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject parsetest (JSONArray jarr, List<Tests> testlist){
        for (Object obj : jarr) {
            JSONObject jobj = (JSONObject) obj;
            testlist.add(new Tests(jobj.get("id").toString(),jobj.get("title").toString(),""));
            if (jobj.get("values")!=null) {
                JSONArray jarr2 = (JSONArray) jobj.get("values");
                parsetest(jarr2, testlist);
            }
        }
        return null;
    }
    public static JSONObject parsevalues(JSONArray jarr, Map<String, String>result){
        for (Object obj : jarr) {
            JSONObject jobj = (JSONObject) obj;
            result.put(jobj.get("id").toString(),jobj.get("value").toString());
        }
        return null;
    }
}