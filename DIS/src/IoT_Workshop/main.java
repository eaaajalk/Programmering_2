package IoT_Workshop;
import java.io.IOException;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class main {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        String broker = "tcp://192.168.1.1:1883";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker,  MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
// her
            SimpleMqttCallBack simpleMqttCallBack = new SimpleMqttCallBack();
            sampleClient.setCallback(simpleMqttCallBack);
            simpleMqttCallBack.setClient(sampleClient);

            System.out.println("Connected");
            String topic = "tele/grp3870/SENSOR";

            sampleClient.subscribe(topic);

            Thread.sleep(200000);



            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();

        }
    }

    // Opgave 6
    public static void publishMessage(MqttClient sampleClient,String topicsend,String content) throws MqttPersistenceException, MqttException {
        // Laver en publish pÂ sampleClient med topic topicsend og indhold content.
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        System.out.println(content.getBytes());
        sampleClient.publish(topicsend, message);
        System.out.println("Message published");
    }
}

