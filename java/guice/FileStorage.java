package org.rap.prgtests.guice;

class FileStorage implements Storage{

    public void store(String uniqueId, String data){
        // Store the object in a file using Java Serialization mechanism.
    }

    public String retrieve(String uniqueId){
		return uniqueId;
        // Code to retrieve the object.
    }

}