package IoT_Workshop;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import static IoT_Workshop.main.publishMessage;

public class SimpleMqttCallBack implements MqttCallback {
    int status = 0;
    MqttClient sampleClient;
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void setClient(MqttClient sampleClient) {
        this.sampleClient = sampleClient;
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String res= new String(mqttMessage.getPayload());

        //System.out.println(res);

        JSONObject jo = new JSONObject(res);
        JSONObject jo2 = jo.getJSONObject("AM2301");
        double temperature = jo2.getDouble("Temperature");
        double humidity = jo2.getDouble("Humidity");
        System.out.println("Temp: " + temperature + " Fugtighed: " + humidity);

        if (humidity > 85) {
            publishMessage(sampleClient, "cmnd/grp3870/Power1", "1");
        } else {
            publishMessage(sampleClient, "cmnd/grp3870/Power1", "0");
        }
    }
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }

} 