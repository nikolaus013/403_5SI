package connection;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ServiceConnection implements Connection {

    CloseableHttpClient client;
    String url = "http://localhost:8086/SQLservice/repository";

    @Override
    public void Connect() {
        client = HttpClients.createDefault();
    }

    @Override
    public String getTableNames() {
        HttpGet get = new HttpGet("http://localhost:8086/SQLservice/repository");
        System.out.println(get.toString());
        String jsonString = null;
        try {
            CloseableHttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                InputStream in = entity.getContent();
                try {
                    jsonString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                } finally {
                    in.close();
                    response.close();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    public String getTableData(String tableName) {
        String path = url + "/" + tableName;
        String jsonString = null;
        try {
            HttpGet get = new HttpGet(path);
            System.out.println(get.toString());
            CloseableHttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                InputStream in = entity.getContent();
                try {
                    jsonString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                } finally {
                    in.close();
                    response.close();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    public void insertInto(String tableName) {
        HttpPost post = new HttpPost(url);
        String json = "{}";
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFrom(String tableName) {

    }
}
