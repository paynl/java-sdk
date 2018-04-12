package nl.pay.sdk.servicelist;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * paymentOptionSubList is returned as an empty string when no subs are present.
 * gson does not understand this.
 * that is why we need to override the serializer for this object
 */
public class PaymentOptionSerializer implements JsonDeserializer<PaymentOption> {
    public PaymentOption deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        PaymentOption result = new PaymentOption();

        result.id = jsonObject.get("id").getAsInt();
        result.name = jsonObject.get("name").getAsString();
        result.visibleName = jsonObject.get("visibleName").getAsString();
        result.img = jsonObject.get("img").getAsString();
        result.path = jsonObject.get("path").getAsString();
        result.state = jsonObject.get("state").getAsInt();
        result.useOnlyInStore = jsonObject.get("useOnlyInStore").getAsInt();
        result.paymentMethodId = jsonObject.get("paymentMethodId").getAsInt();

        Type optionSubListType = new TypeToken<Map<Integer,PaymentOptionSub>>(){}.getType();

        try{
            result.paymentOptionSubList = new Gson().fromJson(jsonObject.get("paymentOptionSubList"), optionSubListType);
        } catch (JsonSyntaxException e){
            result.paymentOptionSubList = null;
        }

        return result;
    }
}
