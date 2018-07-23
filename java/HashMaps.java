package org.rap.prgtests;

import java.util.HashMap;
import java.util.Map;

//import java.util.Map;

public class HashMaps {
        class Command{
                public String command;
                public Map<String, String> params=null;
                public void setCommand(String command){
                        this.command=command;
                }
                public Command(){
                	params=new HashMap<String, String>();
                }
                public void addParameter(String name, String value) {
                        this.params.put(name, value);
                }
                public void listContents(){
                        System.out.println("COMMAND: "+this.command);
                        for(String key: params.keySet()){
                        	System.out.println("PARAM "+key+":"+this.params.get(key));
                        }
                }
        }
        public HashMaps(String cmdText){
                String paramArray[];
                String lines[] = cmdText.split("\\r?\\n");

                Command c=new Command();
                c.setCommand(lines[0]);

                System.out.println("lines:"+lines.length);
                for(int a=1; a<lines.length; a++){
                	paramArray=lines[a].split(":", 2);
                    c.addParameter(paramArray[0], paramArray[1]);
                }
                
                c.listContents();
        }
        public static void main(String args[]) {
                new HashMaps("md.start\na:1\nb:2");
        }
}