//
//  Autogenerated by CocoaTouchApiGenerator
//
//  DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//



#import "EsLogOutRequest.h"
#import "EsThriftUtil.h"

@implementation EsLogOutRequest

@synthesize dropConnection = dropConnection_;
@synthesize dropAllConnections = dropAllConnections_;

- (id) initWithThriftObject: (id) thriftObject {
	if ((self = [super init])) {
		self.messageType = EsMessageType_LogOutRequest;
		self.dropAllConnections = true;
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
	ThriftLogOutRequest* t = (ThriftLogOutRequest*) thriftObject;
	if ([t dropConnectionIsSet]) {
		self.dropConnection = t.dropConnection;
	}
	if ([t dropAllConnectionsIsSet]) {
		self.dropAllConnections = t.dropAllConnections;
	}
}

- (ThriftLogOutRequest*) toThrift {
	ThriftLogOutRequest* _t = [[ThriftLogOutRequest alloc] init];;
	if (dropConnection_set_) {
		BOOL _dropConnection;
		_dropConnection = self.dropConnection;
		_t.dropConnection = _dropConnection;
	}
	if (dropAllConnections_set_) {
		BOOL _dropAllConnections;
		_dropAllConnections = self.dropAllConnections;
		_t.dropAllConnections = _dropAllConnections;
	}
	return _t;
}

- (id) newThrift {
	return [[ThriftLogOutRequest alloc] init];
}

- (void) setDropConnection: (BOOL) dropConnection {
	dropConnection_ = dropConnection;
	dropConnection_set_ = true;
}

- (void) setDropAllConnections: (BOOL) dropAllConnections {
	dropAllConnections_ = dropAllConnections;
	dropAllConnections_set_ = true;
}


@end
