package com.geektime.springdemo03;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpConnection;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Slf4j
@Component
public class HttpRequestDemo {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    /**
     * 通过RestTemplate进行远程调用
     */
    public void test1(){

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080/json").build().toUri();
        ResponseEntity<Person> person1 = restTemplate.getForEntity(uri, Person.class);
        log.info("Response Status: {}, Response Headers: {}", person1.getStatusCode(), person1.getHeaders().toString());
        log.info("Person 1: {}", person1.getBody());
    }

    /**
     * 通过jdk提供的原生API实现远程调用
     */
    public void test2(){
        InputStream in = null;
        try {
            URL url = new URL("http://localhost:8080/json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type","application/json");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("GET");
            in = conn.getInputStream();

            byte[] b = new byte[in.available()];
            in.read(b);

            log.info("Person 2: {}", new String(b));

        } catch (MalformedURLException e) {
            log.error("Error: ",e);
        } catch (IOException e) {
            log.error("Error: ",e);
        }
    }



    /**
     * 基于apache httpclient 实现远程接口调用
     */
    public void test3(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://localhost:8080/json");
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(get);
            log.info("Response Status: {}, Response Headers: {}", response.getStatusLine(), response.getAllHeaders());
            log.info("Person 3: {}", EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            log.error("Error: ", e);
        }
    }



    /**
     * 通过WebClient进行远程调用
     */
    public void test4(){
        webClient.get()
                .uri("/json")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(Person.class)
                .doOnError(t -> log.error("Error: ", t))
                .doFinally(s -> log.info("调用结束"))
                .subscribeOn(Schedulers.single())
                .subscribe(c -> log.info("Person 4: {}", c));
    }

}
