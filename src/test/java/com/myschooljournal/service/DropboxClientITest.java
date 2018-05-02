package com.myschooljournal.service;


import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import com.myschooljournal.util.PropertyLoader;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.myschooljournal.service.ServiceConstants.DROPBOX_TOKEN;

@Ignore("This is integration test for dropboxclient")
public class DropboxClientITest {

    private static final String FILE_PATH="/Users/nataliyaroshchyna/IdeaProjects/journal_desktop/src/test/resources/test.txt";

    private static final String ACCESS_TOKEN = PropertyLoader.getProperty(DROPBOX_TOKEN);

    @Test
    public void shouldReturnResponse() throws DbxException{
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
                //System.out.println(metadata);
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());

        } // Upload "test.txt" to Dropbox
        try (InputStream in = new FileInputStream("/Users/nataliyaroshchyna/IdeaProjects/journal_desktop/src/test/resources/test.txt")) {
            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
                   .uploadAndFinish(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUploadFileToDropbox(){
        DropboxClient.DROPBOX_CLIENT.uploadFile(FILE_PATH,"/file/test.txt");

    }
}