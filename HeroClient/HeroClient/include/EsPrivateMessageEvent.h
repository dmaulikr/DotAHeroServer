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
#import "ThriftPrivateMessageEvent.h"
#import "EsFlattenedEsObject.h"
#import "ThriftFlattenedEsObject.h"

/**
 * This event occurs when a client receives a private message from another user. The event object contains the name of the user that sent it, the message, and an optional EsObject.
 * 
 * This shows how to send a private message to one user and capture an event when one is received.
<pre>
private var _es:ElectroServer;

private function initialize():void {
        _es.engine.addEventListener(MessageType.PrivateMessageEvent.name, onPrivateMessageEvent);
}

private function onPrivateMessageEvent(e:PrivateMessageEvent):void {
        trace(e.userName + " says '" + e.message + "'");
}

private function sendTestMessage():void {
        //create the message object
        var pmr:PrivateMessageRequest = new PrivateMessageRequest();

        //configure it
        pmr.message = "Hello World!";
        pmr.userNames = ["frank"];

        //send it
        _es.engine.send(pmr);
}
</pre>
 */
@interface EsPrivateMessageEvent : EsEvent {
@private
	BOOL userName_set_;
	NSString* userName_;
	BOOL message_set_;
	NSString* message_;
	BOOL esObject_set_;
	EsObject* esObject_;
}

/**
 * Name of the user that sent the message.
 */
@property(strong,nonatomic) NSString* userName;
/**
 * The chat message.
 */
@property(strong,nonatomic) NSString* message;
/**
 * Optional EsObject that was sent with the message.
 */
@property(strong,nonatomic) EsObject* esObject;

- (id) init;
- (id) initWithThriftObject: (id) thriftObject;
- (void) fromThrift: (id) thriftObject;
- (ThriftPrivateMessageEvent*) toThrift;
- (id) newThrift;
@end
