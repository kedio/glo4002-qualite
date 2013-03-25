package ca.ulaval.glo4002.communication;

import java.util.HashMap;

import ca.ulaval.glo4002.common.requestSender.GETRequestSender;
import ca.ulaval.glo4002.common.requestSender.POSTRequestSender;
import ca.ulaval.glo4002.utilities.JSONMessageEncoder;

public class Communicator {

    private static final int CENTRAL_SERVER_PORT = 9001;

    public static enum CommunicationType {
        FIRE, POLICE, REGISTRATION
    };

    protected String resource;
    protected JSONMessageEncoder messageEncoder = new JSONMessageEncoder();
    protected POSTRequestSender postRequestSender = new POSTRequestSender(CENTRAL_SERVER_PORT);
    protected GETRequestSender getRequestSender = new GETRequestSender(CENTRAL_SERVER_PORT);;

    public Communicator(int userID, CommunicationType communicationType) {
        resource = generateResourceURL(userID, communicationType);
    }

    protected Communicator() {

    }

    private String generateResourceURL(int userID, CommunicationType communicationType) {
        return String.format("client/%d/%s", userID, communicationType.toString().toLowerCase());
    }

    public void sendMessageToCentralServer() {
        getRequestSender.sendRequest(resource);
    }

    public void sendMessageToCentralServer(HashMap<String, String> attributes) {
        String messageToSend = messageEncoder.generateEncodedMessage(attributes);
        postRequestSender.sendRequest(resource, messageToSend);
    }

}