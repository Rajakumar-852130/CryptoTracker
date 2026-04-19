package com.example.demo.Service;


import com.example.demo.model.CryptoCoin;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {

    private final String API_URL = "https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd&include_24hr_change=true";

    public List<CryptoCoin> getCryptoPrices(List<String> coins) {
        String ids = String.join(",", coins);
        String url = String.format(API_URL, ids);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        List<CryptoCoin> coinList = new ArrayList<>();

        for (String coin : coins) {
            if (json.has(coin)) {
                JSONObject coinJson = json.getJSONObject(coin);
                double price = coinJson.getDouble("usd");
                double change24h = coinJson.getDouble("usd_24h_change");
                coinList.add(new CryptoCoin(coin, coin, price, change24h));
            }
        }
         return coinList;
    }
}