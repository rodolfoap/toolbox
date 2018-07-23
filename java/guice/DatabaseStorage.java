package org.rap.prgtests.guice;

class DatabaseStorage implements Storage{

    public void store(String uniqueId, String data){
        // Open a connection and store the data.
    }

    public String retrieve(String uniqueId){
		return uniqueId;
        // Get the data from the Database.
    }

}