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
#import "ThriftGetUsersInRoomRequest.h"

/**
 * This request allows a client to load the list of users in any room. The zone id and room id need to be specified. This leads to a GetUsersInRoomResponse, which contains a list of 
 UserListEntry objects describing the list of users. Each UserListEntry object contains properties about a user such as the userName and userVariables.
 * 
 * This example shows how to request the list of users in a room, capture the response, and print the results.
<pre>
private var _es:ElectroServer;
private var _room:Room;

private function initialize():void {
        _es.engine.addEventListener(MessageType.GetUsersInRoomResponse.name, onGetUsersInRoomResponse);

        var guir:GetUsersInRoomRequest = new GetUsersInRoomRequest();
        guir.zoneId = _room.zoneId;
        guir.roomId = _room.id;
        _es.engine.send(guir);
}

private function onGetUsersInRoomResponse(e:GetUsersInRoomResponse):void {
        trace("Users in this room: " + e.roomId.toString());
        for each (var ule:UserListEntry in e.users) {
                trace(ule.userName);
        }
}
</pre>
 */
@interface EsGetUsersInRoomRequest : EsRequest {
@private
	BOOL zoneId_set_;
	int32_t zoneId_;
	BOOL roomId_set_;
	int32_t roomId_;
}

/**
 * Id of the zone that contains the room.
 */
@property(nonatomic) int32_t zoneId;
/**
 * Id of the room that contains the list of users to load.
 */
@property(nonatomic) int32_t roomId;

- (id) init;
- (id) initWithThriftObject: (id) thriftObject;
- (void) fromThrift: (id) thriftObject;
- (ThriftGetUsersInRoomRequest*) toThrift;
- (id) newThrift;
@end
