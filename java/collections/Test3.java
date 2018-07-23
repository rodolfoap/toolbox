package org.rap.prgtests.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Test3 {
	Map<String, List<Integer>> mBreakpointsMap = new HashMap<String, List<Integer>>();

	Test3() {
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mBreakpointsMap.toString());
		addToBreakpointsMap("script1",10);
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mBreakpointsMap.toString());
		addToBreakpointsMap("script1", 20);
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mBreakpointsMap.toString());
		addToBreakpointsMap("script1", 20);
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mBreakpointsMap.toString());
		addToBreakpointsMap("script3", 20);
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":Map:" + mBreakpointsMap.toString());
		
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":find[T]:" + isBreakpointInMap("script1", 10));
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":find[F]:" + isBreakpointInMap("script1", 13));
		System.err.println(new Throwable().getStackTrace()[0].toString()+ ":find[F]:" + isBreakpointInMap("scriptX", 13));
	}

    public void addToBreakpointsMap(String scriptName, int lineNumber) {
        List<Integer> breakpointsList=null;
        if (!this.mBreakpointsMap.containsKey(scriptName)) {
            this.mBreakpointsMap.put(scriptName, Arrays.asList(lineNumber));
        } else {
            breakpointsList=this.mBreakpointsMap.get(scriptName);
            if(!breakpointsList.contains(lineNumber)){
                breakpointsList = new ArrayList<Integer>(breakpointsList);
                breakpointsList.add(lineNumber);
                this.mBreakpointsMap.put(scriptName, breakpointsList);
            }
        }
    }

    public boolean isBreakpointInMap(String scriptName, int lineNumber) {
        List<Integer> breakpointsList=null;
        if (this.mBreakpointsMap.containsKey(scriptName)) {
            breakpointsList=this.mBreakpointsMap.get(scriptName);
            if(breakpointsList.contains(lineNumber)){
            	return true;
            }
        }
       	return false;
    }

	public static void main(String[] args) {
		new Test3();
	}
}
