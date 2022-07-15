package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        query = query.trim();
        query = query.replaceAll(",", "");
        List<String> queryList = Arrays.asList(query.split(" "));
        // What is 1 plus 2
        // 0    1  2 3    4
        //which of the following numbers is the largest: 76, 135
        // 0    1   2   3         4      5   6   7       8   9
        if(query.startsWith("what is")) {
            return String.valueOf( (Integer.parseInt(queryList.get(2)) + Integer.parseInt(queryList.get(4))) );
        } else if (query.startsWith("which of")) {
            if (Integer.parseInt(queryList.get(8)) > Integer.parseInt(queryList.get(9))) {
                return String.valueOf(Integer.parseInt(queryList.get(8)));
            } else {
                return String.valueOf(Integer.parseInt(queryList.get(9)));
            }
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
