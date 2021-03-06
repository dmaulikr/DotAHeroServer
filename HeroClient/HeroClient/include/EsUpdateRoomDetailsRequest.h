//
//  Autogenerated by CocoaTouchApiGenerator
//
//  DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//



#import "EsMessage.h"
#import "EsMessageType.h"
#import "EsRequest.h"
#import "EsResponse.h"
#import "EsEvent.h"
#import "EsEntity.h"
#import "EsObject.h"
#import "ThriftUpdateRoomDetailsRequest.h"

/**
 * Certain properties of a room can be updated by a user in that room after the room has been created. Once a property has changed all users in that room will recieve an UpdateRoomDetailsEvent. 
 The properties that can be updated are roomName, description, capacity, the password, and if the room is hidden or not.
 * 
 * This example shows how to update all possible properties and how to capture the event.
 
<pre>
private var _es:ElectroServer;
private var _room:Room;

private function initialize():void {
        _es.engine.addEventListener(MessageType.UpdateRoomDetailsEvent.name, onUpdateRoomDetailsEvent);

        var urdr:UpdateRoomDetailsRequest = new UpdateRoomDetailsRequest();
        urdr.roomId = _room.id;
        urdr.zoneId = _room.zoneId;

        urdr.roomNameUpdate = true;
        urdr.roomName = "New Room Name";

        urdr.descriptionUpdate = true;
        urdr.description = "new room description";

        urdr.capacityUpdate = true;
        urdr.capacity = 13;

        urdr.hiddenUpdate = true;
        urdr.hidden = true;

        urdr.passwordUpdate = true;
        urdr.password = "new password";

        _es.engine.send(urdr);
}

private function onUpdateRoomDetailsEvent(e:UpdateRoomDetailsEvent):void {
        if (e.roomNameUpdated) {
                trace("roomName: " + e.roomName);
        }
        if (e.descriptionUpdated) {
                trace("description: " + e.description);
        }
        if (e.hasPasswordUpdated) {
                trace("has password: " + e.hasPassword.toString());
        }
        if (e.hiddenUpdated) {
                trace("hidden: " + e.hidden.toString());
        }
        if (e.capacityUpdated) {
                trace("capacity: " + e.capacity.toString());
        }
}

</pre>
 */
@interface EsUpdateRoomDetailsRequest : EsRequest {
@private
	BOOL zoneId_set_;
	int32_t zoneId_;
	BOOL roomId_set_;
	int32_t roomId_;
	BOOL capacityUpdate_set_;
	BOOL capacityUpdate_;
	BOOL capacity_set_;
	int32_t capacity_;
	BOOL roomDescriptionUpdate_set_;
	BOOL roomDescriptionUpdate_;
	BOOL roomDescription_set_;
	NSString* roomDescription_;
	BOOL roomNameUpdate_set_;
	BOOL roomNameUpdate_;
	BOOL roomName_set_;
	NSString* roomName_;
	BOOL passwordUpdate_set_;
	BOOL passwordUpdate_;
	BOOL password_set_;
	NSString* password_;
	BOOL hiddenUpdate_set_;
	BOOL hiddenUpdate_;
	BOOL hidden_set_;
	BOOL hidden_;
}

/**
 * Id of the zone that contains the room
 */
@property(nonatomic) int32_t zoneId;
/**
 * Id of the room
 */
@property(nonatomic) int32_t roomId;
/**
 * If the capacity property has changed, set this to true
 */
@property(nonatomic) BOOL capacityUpdate;
/**
 * Set a value here and set capacityUpdate to true to update the capacity.
 */
@property(nonatomic) int32_t capacity;
/**
 * If the description has changed then set this to true.
 */
@property(nonatomic) BOOL roomDescriptionUpdate;
/**
 * To change the description set a value here and set descriptionUpdate to true
 */
@property(strong,nonatomic) NSString* roomDescription;
/**
 * If the roomName is changinge then set this to true.
 */
@property(nonatomic) BOOL roomNameUpdate;
/**
 * To change the roomName set a value here and set roomNameUpdate to true
 */
@property(strong,nonatomic) NSString* roomName;
/**
 * If the password is changing then set this to true
 */
@property(nonatomic) BOOL passwordUpdate;
/**
 * To change the password set a value here and set passwordUpdate to true. To remove the password, leave this null but still set paswordUpdate to true
 */
@property(strong,nonatomic) NSString* password;
/**
 * If the hidden property is changing then set this to true
 */
@property(nonatomic) BOOL hiddenUpdate;
/**
 * To update the hidden property set the value here and set hiddenUpdate to true
 */
@property(nonatomic) BOOL hidden;

- (id) init;
- (id) initWithThriftObject: (id) thriftObject;
- (void) fromThrift: (id) thriftObject;
- (ThriftUpdateRoomDetailsRequest*) toThrift;
- (id) newThrift;
@end
