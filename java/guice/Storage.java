package org.rap.prgtests.guice;

interface Storage{

    public void store(String uniqueId, String data);
    public String retrieve(String uniqueId);

}