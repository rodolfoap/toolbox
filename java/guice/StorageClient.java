package org.rap.prgtests.guice;

public class StorageClient {

    public static void main(String[] args) {

        // Making use of file storage.
        Storage storage = new FileStorage();
        storage.store("123", new String());

        // Making use of the database.
        storage = new DatabaseStorage();
        storage.store("456", new String());
    }
}