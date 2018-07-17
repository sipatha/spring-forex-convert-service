package cib.eureka.service.srvc;

import cib.eureka.service.model.ConvertRequest;
import cib.eureka.service.model.ConvertResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ForexService {

    @Value("${app.url:test}")
    private String url;

    @Value("${app.appId}")
    private String appId;

    @Autowired
    private ObjectMapper mapper;

    public ConvertResponse getConvert(ConvertRequest request) {

        try {
            HttpUrl hurl = HttpUrl.parse(url)
                    .newBuilder()
                    .addPathSegment(request.getAmount().toPlainString())
                    .addPathSegment(request.getFrom())
                    .addPathSegment(request.getTo())
                    .addQueryParameter("app_id", appId)
                    .build();

            Request req = new Request.Builder()
                    .url(hurl)
                    .build();

            Response res = new OkHttpClient.Builder().build().newCall(req).execute();
            String json = res.body().string();

            return mapper.readerFor(ConvertResponse.class).readValue(json);

        } catch (IOException | NullPointerException e) {
            //-- sed message
            e.printStackTrace();
        }

        return null;
    }

}
