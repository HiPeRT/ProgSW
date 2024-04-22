package it.unimore.hipert.indinf.iotsemaphore.process;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreConfigurationMessage;
import it.unimore.hipert.indinf.iotsemaphore.services.*;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Receive from Mwtt a new ConfigMessage, and dispatch to listeners
 */
public class MqttReceiver implements IMessageReceiver {
    private final static Logger logger = LoggerFactory.getLogger(MqttReceiver.class);

    //IP Address of the target MQTT Broker
    private String brokerAddress;
    //PORT of the target MQTT Broker
    private int brokerPort;
    //MQTT account username to connect to the target broker
    private String mqttUsername;
    //MQTT account password to connect to the target broker
    private String mqttPassword;
    //Basic Topic used to consume generated demo data (the topic is associated to the user)
    private String mqttBasicTopic;

    private IJsonParser<SemaphoreConfigurationMessage> jsonParser;

    private List<IMessageListener> listeners;

    public MqttReceiver(IConfiguration config, IJsonParser parser)
    {
        this.brokerAddress = config.getMqttBrokerAddress();
        this.brokerPort = config.getMqttBrokerPort();
        this.mqttUsername = config.getMqttUsername();
        this.mqttPassword = config.getMqttPassword();
        this.mqttBasicTopic = config.getMqttBasicTopic();

        this.jsonParser = parser;
        this.listeners = new ArrayList<>();
    }

    public void start()     {
        logger.info("MQTT Receiver Started ...");

        try{
            //Generate a random MQTT client ID using the UUID class
            String clientId = UUID.randomUUID().toString();

            //Represents a persistent data store, used to store outbound and inbound messages while they
            //are in flight, enabling delivery to the QoS specified. In that case use a memory persistence.
            //When the application stops all the temporary data will be deleted.
            MqttClientPersistence persistence = new MemoryPersistence();

            //The the persistence is not passed to the constructor the default file persistence is used.
            //In case of a file-based storage the same MQTT client UUID should be used
            IMqttClient client = new MqttClient(
                    String.format("tcp://%s:%d", brokerAddress, brokerPort),
                    clientId,
                    persistence);

            //Define MQTT Connection Options such as reconnection, persistent/clean session and connection timeout
            //Authentication option can be added -> See AuthProducer example
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttUsername);
            options.setPassword((mqttPassword).toCharArray());
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);

            //Connect to the target broker
            client.connect(options);

            logger.info("Connected !");

            //Subscribe to the target topic #. In that case the consumer will receive (if authorized) all the message
            //passing through the broker
            client.subscribe(mqttBasicTopic + "#", (topic, msg) -> {
                //The topic variable contain the specific topic associated to the received message. Using MQTT wildcards
                //messaged from multiple and different topic can be received with the same subscription
                //The msg variable is a MqttMessage object containing all the information about the received message
                byte[] payload = msg.getPayload();
                logger.info("Message Received ({}) Message Received: {}", topic, new String(payload));
                SemaphoreConfigurationMessage message = this.jsonParser.parseObject(payload);
                NotifyAllListeners(message);
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void NotifyAllListeners(SemaphoreConfigurationMessage message) {
        for (IMessageListener lister: listeners) {
            lister.onMessageReceived(message);
        }
    }

    @Override
    public void registerListener(IMessageListener messageListener) {
        listeners.add(messageListener);
    }
}
