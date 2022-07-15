package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();

        List<String> queryList = new ArrayList<>();
        queryList = Arrays.asList(query.split(" "));
        // What is 1 plus 2
        // 0    1  2 3    4
        if(query.startsWith("what is")) {
            return String.valueOf( (Integer.parseInt(queryList.get(2)) + Integer.parseInt(queryList.get(4))) );
        }
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Mihail";
        }  else {
            return "";
        }

    }
}
