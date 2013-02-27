package ca.ulaval.glo4002.communication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class POSTRequestSender {
    private static final String SERVER_URL = "http://localhost:8080/test";
    private static final int RESPONSE_OK = 200;
    private WebResource webResource;

    private String lastResponse;

    public POSTRequestSender() {
        Client client = Client.create();
        webResource = client.resource(SERVER_URL);
    }

    public WebResource getWebResource() {
        return webResource;
    }

    public void sendPostRequest(String resource, String messageToSend) throws RuntimeException {
        ClientResponse response = webResource.type("Application/xml").post(
                ClientResponse.class, messageToSend);
        if (response.getStatus() != RESPONSE_OK) {
            throw new RuntimeException("Failed: HTTP error code: "
                    + response.getStatus());
        }
        lastResponse = response.getEntity(String.class);
    }

    public String getLastResponse() {
        return lastResponse;
    }
}
