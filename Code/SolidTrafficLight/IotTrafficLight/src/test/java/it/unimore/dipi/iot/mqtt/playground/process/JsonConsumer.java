package it.unimore.dipi.iot.mqtt.playground.process;

import it.unimore.dipi.iot.mqtt.playground.model.MessageDescriptor;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import java.util.UUID;

/**
 * MQTT Consumer using the library Eclipse Paho
 * and consuming JSON messages following a structured message description
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project mqtt-playground
 * @created 14/10/2020 - 09:19
 */
public class JsonConsumer {

    private final static Logger logger = LoggerFactory.getLogger(JsonConsumer.class);

    //IP Address of the target MQTT Broker
    private static String BROKER_ADDRESS = "155.185.228.19";

    //PORT of the target MQTT Broker
    private static int BROKER_PORT = 7883;

    public static void main(String [ ] args) {

        logger.info("MQTT JsonConsumer Started ...");

        try{

            //Generate a random MQTT client ID using the UUID class
            String clientId = UUID.randomUUID().toString();

            //Represents a persistent data store, used to store outbound and inbound messages while they
            //are in flight, enabling delivery to the QoS specified. In that case use a memory persistence.
            //When the application stops all the temporary data will be deleted.
            MqttClientPersistence persistence = new MemoryPersistence();

            //The the persistence is not passed to the constructor the default file persistence is used.
            //In case of a file-based storage the same MQTT client UUID should be used
            IMqttClient subscriber = new MqttClient(
                    String.format("tcp://%s:%d", BROKER_ADDRESS, BROKER_PORT), //Create the URL from IP and PORT
                    clientId,
                    persistence);

            //Define MQTT Connection Options such as reconnection, persistent/clean session and connection timeout
            //Authentication option can be added -> See AuthProducer example
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);

            //Connect to the target broker
            subscriber.connect(options);

            logger.info("Connected ! Client Id: {}", clientId);

            //Subscribe to the target topic #. In that case the consumer will receive (if authorized) all the message
            //passing through the broker
            subscriber.subscribe("/iot/user/pburgio/", (topic, msg) -> {

                //The topic variable contain the specific topic associated to the received message. Using MQTT wildcards
                //messaged from multiple and different topic can be received with the same subscription
                //The msg variable is a MqttMessage object containing all the information about the received message
                byte[] payload = msg.getPayload();

                //Through the internal method parseJsonMessage() de-serialize the received Message Descriptor
                MessageDescriptor msgDescriptor = parseJsonMessage(payload);

                //Check and print the received Message
                if(msgDescriptor != null)
                    System.out.println("JSON MessageDescriptor Received ("+topic+") " +
                                    "Data -> Timestamp: " + msgDescriptor.getTimestamp() +"," +
                                    "Type: " + msgDescriptor.getType() + ", " +
                                    "Value: " + msgDescriptor.getValue() + "");
                else
                    logger.info("Message Received ({}) Message Received: {}", topic, new String(payload));
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Parse the received MQTT message into a MessageDescriptor object or null in case of error
     *
     * @param payload
     * @return the parsed MessageDescriptor object or null in case or error.
     */
    public static MessageDescriptor parseJsonMessage(byte[] payload) {

        try {

            Gson gson = new Gson();
            return (MessageDescriptor)gson.fromJson(new String(payload), MessageDescriptor.class);

        }catch(Exception e) {
            return null;
        }

    }
}