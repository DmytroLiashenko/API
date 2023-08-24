import data.Curency;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.Rest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TEstAPI2 {
    Curency currency;
    static JSONArray jsonArray;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Curency.values());
    }
    public TEstAPI2(Curency curency) {

        this.currency = curency;
        jsonArray = new JSONArray(Rest.getRest(("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="
                + currency.getCurency() + "&json")));
    }
    @Test
    public void test1() {
        JSONObject exchange = jsonArray.getJSONObject(0);
        System.out.println(exchange.getString("cc")+" "+(exchange.getFloat("rate")));
    }
}

