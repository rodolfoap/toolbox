package org.rap.prgtests.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Test1 {
	Map<UUID, List<String>> mScriptsMap = new HashMap<UUID, List<String>>();

	Test1() {
		// Map<UUID, List<String>> scriptsMap = new HashMap<UUID,
		// List<String>>();
		mScriptsMap = new HashMap<UUID, List<String>>();
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mScriptsMap.toString());
		UUID test1 = UUID.randomUUID();
		addScriptsMap(test1, "script1");
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mScriptsMap.toString());
		addScriptsMap(test1, "script2");
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mScriptsMap.toString());
		addScriptsMap(test1, "script2");
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mScriptsMap.toString());
		addScriptsMap(UUID.randomUUID(), "script2");
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mScriptsMap.toString());
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":find[True]:" + findScriptInMap(test1, "script1"));
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":find[False]:" + findScriptInMap(test1, "scriptX"));
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":find[False]:" + findScriptInMap(UUID.randomUUID(), "script1"));
	}

    public void addScriptsMap(UUID currentUUID, String scriptName) {
        List<String> scriptList=null;
        if (!this.mScriptsMap.containsKey(currentUUID)) {
            this.mScriptsMap.put(currentUUID, Arrays.asList(scriptName));
        } else {
            scriptList=this.mScriptsMap.get(currentUUID);
            if(!scriptList.contains(scriptName)){
                scriptList = new ArrayList<String>(scriptList);
                scriptList.add(scriptName);
                this.mScriptsMap.put(currentUUID, scriptList);
            }
        }
    }

    public boolean findScriptInMap(UUID currentUUID, String scriptName) {
        List<String> scriptList=null;
        if (this.mScriptsMap.containsKey(currentUUID)) {
            scriptList=this.mScriptsMap.get(currentUUID);
            if(scriptList.contains(scriptName)){
            	return true;
            }
        }
       	return false;
    }

	public static void main(String[] args) {
		new Test1();
	}
}
