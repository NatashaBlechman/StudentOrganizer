package com.myschooljournal.service;


import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import com.myschooljournal.util.PropertyLoader;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static com.myschooljournal.service.dropboxservice.DropboxClient.DROPBOX_CLIENT;
import static com.myschooljournal.service.ServiceConstants.DROPBOX_TOKEN;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;


@Ignore("This is integration test for dropboxclient")
public class DropboxClientITest {
    //todo: fix path
    private static final String FILE_PATH =
            new File("test.txt").getAbsolutePath();

    private static final String ACCESS_TOKEN = PropertyLoader.getProperty(DROPBOX_TOKEN);

    @Test
    public void shouldReturnResponse() throws DbxException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial")
                .withUserLocale("en_US")
                .build();
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
        try (InputStream in = new FileInputStream(FILE_PATH)) {
            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
                    .uploadAndFinish(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUploadFileToDropbox() {
        DROPBOX_CLIENT.uploadFile(FILE_PATH, "/file1/test.txt");


    }

    @Test
    public void shouldReturnUploadedFile() {
        DROPBOX_CLIENT.downloadFile("test.txt", "/file1/test.txt");


    }


    @Test
    public void givenFileName_whenUsingFileUtils_thenFileData() throws IOException {


        String expected_value = "hello";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());


         String   data = FileUtils.readFileToString(file,UTF_8);

        assertEquals(expected_value, data.trim());

        //Class clazz = FileOperationsTest.class;
       // InputStream inputStream = clazz.getResourceAsStream("/Users/nataliyaroshchyna/IdeaProjects/journal_desktop/src/test/resources/test.txt");
        //String data;
        //data = readFromInputStream(inputStream);

       // Assert.assertThat(data, containsString(expected_value));
        //String expectedData = "/Users/nataliyaroshchyna/IdeaProjects/journal_desktop/src/test/resources/test.txt";

        //ClassLoader classLoader = getClass().getClassLoader();
        // new File(classLoader.getResource(expectedData).getFile());


        //String data = FileUtils.readFileToString(file, FILE_PATH);


        // Assert.assertEquals(expected_value,expectedData);
        //}
//}

        //BufferedReader br = null;
       // try

        //{
           // br = new BufferedReader(new FileReader(expectedData));
        //} catch (
              //  FileNotFoundException e)

        //{
          //  e.printStackTrace();
        //}

       // try

        //{
            //String Line = br.readLine();
       // } catch (
                //IOException e)

       // {
           // e.printStackTrace();
        //}
       // try

        //{
           // br.close();
       // } catch (
               // IOException e)

       // {
            //e.printStackTrace();
       // }
       // Assert.assertEquals(expected_value, expectedData);


    }
}




