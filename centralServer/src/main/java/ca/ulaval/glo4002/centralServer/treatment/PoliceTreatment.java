package ca.ulaval.glo4002.centralServer.treatment;

import ca.ulaval.glo4002.centralServer.communication.CommunicationUnit;
import ca.ulaval.glo4002.centralServer.communication.CommunicationUnit.CommunicationType;
import ca.ulaval.glo4002.centralServer.user.UserNotFoundException;
import ca.ulaval.glo4002.centralServer.user.UsersDirectory;

public class PoliceTreatment extends EmergencyTreatment {

    public PoliceTreatment() {
        super();
        communicationUnit = new CommunicationUnit(CommunicationType.INTRUSION);
    }

    public void processRequest(final String userIdPassedByGetRequest) throws UserNotFoundException {
        int userId = Integer.parseInt(userIdPassedByGetRequest);
        if (usersDirectory.userExists(userId)) {
            communicationUnit.send(usersDirectory.obtainUser(userId));
        } else {
            throw new UserNotFoundException();
        }
    }

    // for test purpose only
    protected PoliceTreatment(final UsersDirectory usersDirectory, final CommunicationUnit communicationUnit) {
        super(usersDirectory, communicationUnit);
    }
}
