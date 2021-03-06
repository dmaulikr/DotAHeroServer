//
//  Autogenerated by CocoaTouchApiGenerator
//
//  DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//



#import "EsLeaveRoomRequest.h"
#import "EsThriftUtil.h"

@implementation EsLeaveRoomRequest

@synthesize zoneId = zoneId_;
@synthesize roomId = roomId_;

- (id) initWithThriftObject: (id) thriftObject {
	if ((self = [super init])) {
		self.messageType = EsMessageType_LeaveRoomRequest;
		if (thriftObject != nil) {
			[self fromThrift: thriftObject];
		}
	}
	return self;
}

- (id) init {
	return [self initWithThriftObject: nil];
}

- (void) fromThrift: (id) thriftObject {
	ThriftLeaveRoomRequest* t = (ThriftLeaveRoomRequest*) thriftObject;
	if ([t zoneIdIsSet]) {
		self.zoneId = t.zoneId;
	}
	if ([t roomIdIsSet]) {
		self.roomId = t.roomId;
	}
}

- (ThriftLeaveRoomRequest*) toThrift {
	ThriftLeaveRoomRequest* _t = [[ThriftLeaveRoomRequest alloc] init];;
	if (zoneId_set_) {
		int32_t _zoneId;
		_zoneId = self.zoneId;
		_t.zoneId = _zoneId;
	}
	if (roomId_set_) {
		int32_t _roomId;
		_roomId = self.roomId;
		_t.roomId = _roomId;
	}
	return _t;
}

- (id) newThrift {
	return [[ThriftLeaveRoomRequest alloc] init];
}

- (void) setZoneId: (int32_t) zoneId {
	zoneId_ = zoneId;
	zoneId_set_ = true;
}

- (void) setRoomId: (int32_t) roomId {
	roomId_ = roomId;
	roomId_set_ = true;
}


@end
