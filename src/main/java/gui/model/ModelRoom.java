
package gui.model;

import javax.swing.Icon;

/**
 *
 * @author HO MINH HAU
 */
public class ModelRoom {

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Icon getIcon() {
        return icon;
    }

    public ModelRoom(String roomId, String roomName, Icon icon) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.icon = icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
     public ModelRoom() {
    }
    
    String roomId;
    String roomName;
    Icon icon;
}
