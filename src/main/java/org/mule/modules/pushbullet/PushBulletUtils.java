package org.mule.modules.pushbullet;

import java.util.List;

/**
 * Created by estebanwasinger on 2/6/15.
 */
public class PushBulletUtils {
    public static String listToJSONList(List<String> list){
        String newList = "[";
        for(String string : list){
            newList = newList.concat("\""+string+"\",");
        }
        return newList.substring(0,newList.length()-1).concat("]");
    }
}
